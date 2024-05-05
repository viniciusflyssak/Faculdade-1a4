package com.utfpr.trabalho_zoo.codecs;

import com.utfpr.trabalho_zoo.model.Animal;
import org.bson.BsonInt64;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class AnimalCodec implements CollectibleCodec<Animal> {

    private final Codec<Document> codec;

    public AnimalCodec(Codec<Document> codec) {
        this.codec = codec;
    }

    @Override
    public Class<Animal> getEncoderClass() {
        return Animal.class;
    }//Esse metodo diz qual classe será codificada

    @Override
    public boolean documentHasId(Animal animal) {
        return animal.getId() == 0;
    }//Esse metodo só verifica se o objeto chamado tem ID

    @Override
    public BsonValue getDocumentId(Animal animal) {
        if (!documentHasId(animal))//Verifica se o ID foi criado
        {
            throw new IllegalStateException("Esse documento não tem ID");
        } else//Para que o ID possa ser lido é preciso converter para a base hexadecimal
        {
            return new BsonInt64(animal.getId());
        }
    }

    @Override
    public Animal generateIdIfAbsentFromDocument(Animal animal) {
        return documentHasId(animal) ? animal.criaId() : animal;
    }

    @Override
    public void encode(BsonWriter writer, Animal animal, EncoderContext ec) {
        /*Esse metodo pega um Objeto e o envia para o Mongodb, um bom exemplo
        seria dizer para o mongodb qual a receita ele deve seguir para poder 
        salvar o Objeto ANIMAL em sua base de dados*/
        int id = animal.getId();
        String nome = animal.getNome();
        String especie = animal.getEspecie();
        int profissional = animal.getProfissional();
        String nomeCientifico = animal.getNomeCientifico();
        String familia = animal.getFamilia();
        String comportamentos = animal.getComportamentos();

        Document doc = new Document();
        doc.put("_id", id);
        doc.put("nome", nome);
        doc.put("especie", especie);
        doc.put("profissional", profissional);
        doc.put("nomeCientifico", nomeCientifico);
        doc.put("familia", familia);
        doc.put("comportamentos", comportamentos);

        codec.encode(writer, doc, ec);
    }

    @Override
    public Animal decode(BsonReader reader, DecoderContext dc) {
        Document doc = codec.decode(reader, dc);
        Animal animal = new Animal();
        animal.setId(doc.getInteger("_id"));
        animal.setNome(doc.getString("nome"));
        animal.setEspecie(doc.getString("especie"));
        animal.setProfissional(doc.getInteger("profissional"));        
        animal.setNomeCientifico(doc.getString("nomeCientifico"));
        animal.setFamilia(doc.getString("familia"));        
        animal.setComportamentos(doc.getString("comportamentos"));

        return animal;
    }
}
