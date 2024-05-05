package com.utfpr.trabalho_zoo.codecs;

import com.utfpr.trabalho_zoo.model.Servico;
import org.bson.BsonInt64;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ServicoCodec implements CollectibleCodec<Servico> {

    private final Codec<Document> codec;

    public ServicoCodec(Codec<Document> codec) {
        this.codec = codec;
    }

    @Override
    public Class<Servico> getEncoderClass() {
        return Servico.class;
    }//Esse metodo diz qual classe será codificada

    @Override
    public boolean documentHasId(Servico servico) {
        return servico.getId() == 0;
    }//Esse metodo só verifica se o objeto chamado tem ID

    @Override
    public BsonValue getDocumentId(Servico servico) {
        if (!documentHasId(servico))//Verifica se o ID foi criado
        {
            throw new IllegalStateException("Esse documento não tem ID");
        } else//Para que o ID possa ser lido é preciso converter para a base hexadecimal
        {
            return new BsonInt64(servico.getId());
        }
    }

    @Override
    public Servico generateIdIfAbsentFromDocument(Servico servico) {
        return documentHasId(servico) ? servico.criaId() : servico;
    }

    @Override
    public void encode(BsonWriter writer, Servico servico, EncoderContext ec) {
        /*Esse metodo pega um Objeto e o envia para o Mongodb, um bom exemplo
        seria dizer para o mongodb qual a receita ele deve seguir para poder 
        salvar o Objeto SERVICO em sua base de dados*/
        int id = servico.getId();
        String nome = servico.getNome();
        String descricao = servico.getDescricao();
        int profissional = servico.getProfissional();
        int animal = servico.getAnimal();
        String data = servico.getData();
        boolean concluido = servico.isConcluido();

        Document doc = new Document();
        doc.put("_id", id);
        doc.put("nome", nome);
        doc.put("descricao", descricao);
        doc.put("profissional", profissional);
        doc.put("animal", animal);
        doc.put("data", data);
        doc.put("concluido", concluido);

        codec.encode(writer, doc, ec);
    }

    @Override
    public Servico decode(BsonReader reader, DecoderContext dc) {
        Document doc = codec.decode(reader, dc);
        Servico servico = new Servico();
        servico.setId(doc.getInteger("_id"));
        servico.setNome(doc.getString("nome"));
        servico.setDescricao(doc.getString("descricao"));
        servico.setAnimal(doc.getInteger("animal"));
        servico.setProfissional(doc.getInteger("profissional"));
        servico.setData(doc.getString("data"));
        servico.setConcluido(doc.getBoolean("concluido"));

        return servico;
    }
}
