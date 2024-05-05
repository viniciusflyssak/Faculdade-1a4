package com.utfpr.trabalho_zoo.codecs;

import com.utfpr.trabalho_zoo.model.Funcionario;
import org.bson.BsonInt64;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class FuncionarioCodec implements CollectibleCodec<Funcionario> {

    private final Codec<Document> codec;

    public FuncionarioCodec(Codec<Document> codec) {
        this.codec = codec;
    }

    @Override
    public Class<Funcionario> getEncoderClass() {
        return Funcionario.class;
    }//Esse metodo diz qual classe será codificada

    @Override
    public boolean documentHasId(Funcionario funcionario) {
        return funcionario.getId() == 0;
    }//Esse metodo só verifica se o objeto chamado tem ID

    @Override
    public BsonValue getDocumentId(Funcionario funcionario) {
        if (!documentHasId(funcionario))//Verifica se o ID foi criado
        {
            throw new IllegalStateException("Esse documento não tem ID");
        } else//Para que o ID possa ser lido é preciso converter para a base hexadecimal
        {
            return new BsonInt64(funcionario.getId());
        }
    }

    @Override
    public Funcionario generateIdIfAbsentFromDocument(Funcionario funcionario) {
        return documentHasId(funcionario) ? funcionario.criaId() : funcionario;
    }

    @Override
    public void encode(BsonWriter writer, Funcionario funcionario, EncoderContext ec) {
        /*Esse metodo pega um Objeto e o envia para o Mongodb, um bom exemplo
        seria dizer para o mongodb qual a receita ele deve seguir para poder 
        salvar o Objeto FUNCIONARIO em sua base de dados*/
        int id = funcionario.getId();
        String nome = funcionario.getNome();
        String profissao = funcionario.getProfissao();
        String sexo = funcionario.getSexo();
        String cpf = funcionario.getCpf();

        Document doc = new Document();
        doc.put("_id", id);
        doc.put("nome", nome);
        doc.put("profissao", profissao);
        doc.put("sexo", sexo);
        doc.put("cpf", cpf);

        codec.encode(writer, doc, ec);
    }

    @Override
    public Funcionario decode(BsonReader reader, DecoderContext dc) {
        Document doc = codec.decode(reader, dc);
        Funcionario funcionario = new Funcionario();
        funcionario.setId(doc.getInteger("_id"));
        funcionario.setNome(doc.getString("nome"));
        funcionario.setProfissao(doc.getString("profissao"));
        funcionario.setSexo(doc.getString("sexo"));
        funcionario.setCpf(doc.getString("cpf"));

        return funcionario;
    }
}
