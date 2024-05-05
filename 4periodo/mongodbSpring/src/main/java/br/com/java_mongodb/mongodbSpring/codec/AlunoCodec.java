package br.com.java_mongodb.mongodbSpring.codec;

import br.com.java_mongodb.mongodbSpring.model.Aluno;
import br.com.java_mongodb.mongodbSpring.model.Disciplina;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

public class AlunoCodec implements CollectibleCodec<Aluno> {

    private Codec<Document> codec;

    public AlunoCodec(Codec<Document> codec) {
        this.codec = codec;
    }

    @Override
    public Class<Aluno> getEncoderClass() {
        return Aluno.class;
    }//Esse metodo diz qual classe será codificada

    @Override
    public boolean documentHasId(Aluno aluno) {
        return aluno.getId() == null;
    }//Esse metodo só verifica se o objeto chamado tem ID

    @Override
    public BsonValue getDocumentId(Aluno aluno) {
        if (!documentHasId(aluno))//Verifica se o ID foi criado
        {
            throw new IllegalStateException("Esse documento não tem ID");
        } else//Para que o ID possa ser lido é preciso converter para a base hexadecimal
        {
            return new BsonString(aluno.getId().toHexString());
        }
    }

    @Override
    public Aluno generateIdIfAbsentFromDocument(Aluno aluno) {
        return documentHasId(aluno) ? aluno.criaId() : aluno;
    }

    @Override
    public void encode(BsonWriter writer, Aluno aluno, EncoderContext ec) {
        /*Esse metodo pega um Objeto e o envia para o Mongodb, um bom exemplo
        seria dizer para o mongodb qual a receita ele deve seguir para poder 
        salvar o Objeto ALUNO em sua base de dados*/
        ObjectId id = aluno.getId();
        String nome = aluno.getNome();
        Date idade = aluno.getIdade();
        String curso = aluno.getCurso();
        List<Disciplina> disciplinas = aluno.getDisciplinas();

        Document doc = new Document();
        doc.put("_id", id);
        doc.put("nome", nome);
        doc.put("idade", idade);
        doc.put("curso", curso);

        if (disciplinas != null) {
            //Se não tiver uma disciplina cadastrada, 
            //cria-se uma lista para não um NPE
            List<Document> disciplinaDoc = new ArrayList<>();

            //se houver disciplinas itera sobre elas para criar
            //um array de disciplinas no MONGODB
            for (Disciplina disciplina : disciplinas) {
                disciplinaDoc.add(new Document(
                        "nome", disciplina.getNome())
                        .append("professor", disciplina.getProfessor())
                        .append("semestre", disciplina.getSemestre())
                        .append("notas", disciplina.getNotas())
                );
            }
            doc.put("disciplinas",disciplinaDoc);
        }

        codec.encode(writer, doc, ec);
        //Essa função é quem traduz o que escrevemos na VIEW
    }

    @Override
    public Aluno decode(BsonReader reader, DecoderContext dc) {
        Document doc = codec.decode(reader, dc);
        Aluno aluno = new Aluno();
        aluno.setId(doc.getObjectId("_id"));
        aluno.setNome(doc.getString("nome"));
        aluno.setCurso(doc.getString("curso"));        
        aluno.setIdade(doc.getDate("idade"));

        List<Document> disciplinas = (List<Document>) doc.get("disciplinas");

        if (disciplinas != null) {
            List<Disciplina> disciplinaDoAluno = new ArrayList<>();

            for (Document document : disciplinas){
                disciplinaDoAluno.add(new Disciplina(
                    document.getString("nome"),
                    document.getString("professor"),
                    document.getInteger("semestre"),
                    document.getList("notas", Double.class)
                    ));
            }
            aluno.setDisciplinas(disciplinaDoAluno);
        }
        return aluno;
    }
}
