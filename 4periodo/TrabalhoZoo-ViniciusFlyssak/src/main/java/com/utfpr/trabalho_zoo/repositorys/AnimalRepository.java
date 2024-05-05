package com.utfpr.trabalho_zoo.repositorys;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Indexes.descending;
import com.utfpr.trabalho_zoo.codecs.AnimalCodec;
import com.utfpr.trabalho_zoo.model.Animal;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalRepository {

    private MongoClient client;
    private MongoDatabase db;

    public void conecta() {
        //Instaciar um codec
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);

        //Qual classe ira sofrer o encode/decode
        AnimalCodec animalCodec = new AnimalCodec(codec);

        //Instanciar um registro para o codec
        CodecRegistry registro = CodecRegistries
                .fromRegistries(MongoClient.getDefaultCodecRegistry(),
                        CodecRegistries.fromCodecs(animalCodec));

        //Dar um build no registro
        MongoClientOptions op = MongoClientOptions.builder().
                codecRegistry(registro).build();

        this.client = new MongoClient("localhost:27017", op);
        this.db = client.getDatabase("ZOOLOGICO");
    }

    public void salvar(Animal animal) {
        conecta();
        MongoCollection<Animal> animais = db.getCollection("animais", Animal.class);
        animais.insertOne(animal);
        client.close();
    }

    public List<Animal> listarTodos() {
        conecta();
        MongoCollection<Animal> animais = db.getCollection("animais", Animal.class);
        MongoCursor<Animal> resultado = animais.find().iterator();
        List<Animal> animaisLista = new ArrayList<>();

        while (resultado.hasNext()) {
            Animal animal = resultado.next();
            animaisLista.add(animal);
        }
        client.close();
        return animaisLista;
    }

    public int buscaUltimoID() {
        conecta();
        MongoCollection<Animal> animals = db.getCollection("animais", Animal.class);
        Animal animal = animals.find().sort(descending("_id")).limit(1).first();
        client.close();
        if (animal != null) {
            return animal.getId();
        } else {
            return 0;
        }
    }
    
    public Animal buscarAnimal(int id) {
        Document filtro = new Document("_id", id);
        conecta();
        MongoCollection<Animal> animals = db.getCollection("animais", Animal.class);
        Animal animal = animals.find(filtro).first();
        client.close();
        if (animal != null) {
            return animal;
        } else {            
            return null;
        }
    }
    
    public void salvarEdicao(Animal animalEditado) {
        Document filtro = new Document("_id", animalEditado.getId());        
        int id = animalEditado.getId();
        String nome = animalEditado.getNome();
        String especie = animalEditado.getEspecie();
        int profissional = animalEditado.getProfissional();
        String nomeCientifico = animalEditado.getNomeCientifico();
        String familia = animalEditado.getFamilia();
        String comportamentos = animalEditado.getComportamentos();
        Document docAnimal = new Document("$set", new Document()
        .append("nome", nome)
        .append("especie", especie)
        .append("profissional", profissional)
        .append("nomeCientifico", nomeCientifico)
        .append("familia", familia)
        .append("comportamentos", comportamentos));
        conecta();
        MongoCollection<Animal> animais = db.getCollection("animais", Animal.class);
        animais.updateOne(filtro, docAnimal);
        client.close();
    }
    
    public Animal excluirAnimal(int id) {
        Document filtro = new Document("_id", id);
        conecta();
        MongoCollection<Animal> animais = db.getCollection("animais", Animal.class);
        Animal animal = animais.findOneAndDelete(filtro);
        client.close();
        if (animal != null) {
            return animal;
        } else {            
            return null;
        }
    }
}
