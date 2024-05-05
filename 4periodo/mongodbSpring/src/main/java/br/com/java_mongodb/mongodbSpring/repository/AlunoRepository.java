package br.com.java_mongodb.mongodbSpring.repository;

import br.com.java_mongodb.mongodbSpring.codec.AlunoCodec;
import br.com.java_mongodb.mongodbSpring.model.Aluno;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoRepository {

    private MongoClient cliente;
    private MongoDatabase db;

    public void conecta() {
        //Instaciar um codec
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry()
                .get(Document.class);

        //Qual classe ira sofrer o encode/decode
        AlunoCodec alunoCodec = new AlunoCodec(codec);

        //Instanciar um registro para o codec
        CodecRegistry registro = CodecRegistries
                .fromRegistries(MongoClient.getDefaultCodecRegistry(),
                        CodecRegistries.fromCodecs(alunoCodec));

        //Dar um build no registro
        MongoClientOptions op = MongoClientOptions.builder().
                codecRegistry(registro).build();

        this.cliente = new MongoClient("localhost:27017", op);
        this.db = cliente.getDatabase("Aula");
    }

    public void salvar(Aluno aluno) {
        conecta();
        MongoCollection<Aluno> alunos = db.getCollection("alunos", Aluno.class);
        System.out.println("CAIU NO SALVAR");
        System.out.println("Aluno: -------------- "+aluno.getId());
        System.out.println("Aluno: -------------- "+aluno.getNome());
        if(aluno.getId() == null){//se não tiver um aluno, crio uma aluno
            System.out.println("CAIU NO INSERT");
            alunos.insertOne(aluno);
        }else{//se o aluno já existir salva somente as alterações
            System.out.println("CAIU NO UPDATE");
            alunos.updateOne(Filters.eq("_id", aluno.getId()), new Document("$set",aluno));
        }        
        cliente.close();
    }

    public List<Aluno> listarTodos() {
        conecta();
        MongoCollection<Aluno> alunos = db.getCollection("alunos", Aluno.class);
        MongoCursor<Aluno> resultado = alunos.find().iterator();
        List<Aluno> alunoLista = new ArrayList<>();
        
        while(resultado.hasNext()){
            Aluno aluno = resultado.next();
            alunoLista.add(aluno);
        }
        cliente.close();
        return alunoLista;
    }
    
    public Aluno obterId(String id){
        conecta();
        MongoCollection<Aluno> alunos = db.getCollection("alunos", Aluno.class);
        Aluno aluno = alunos.find(Filters.eq("_id", new ObjectId(id))).first();
        return aluno;
    }

    public void excluir(String id) {
        conecta();
        MongoCollection<Aluno> alunos = db.getCollection("alunos", Aluno.class);
        alunos.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
}