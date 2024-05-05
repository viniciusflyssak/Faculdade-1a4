package com.utfpr.trabalho_zoo.repositorys;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Indexes.descending;
import com.utfpr.trabalho_zoo.codecs.ServicoCodec;
import com.utfpr.trabalho_zoo.model.Funcionario;
import com.utfpr.trabalho_zoo.model.Servico;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class ServicoRepository {

    private MongoClient client;
    private MongoDatabase db;

    public void conecta() {
        //Instaciar um codec
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);

        //Qual classe ira sofrer o encode/decode
        ServicoCodec servicoCodec = new ServicoCodec(codec);

        //Instanciar um registro para o codec
        CodecRegistry registro = CodecRegistries
                .fromRegistries(MongoClient.getDefaultCodecRegistry(),
                        CodecRegistries.fromCodecs(servicoCodec));

        //Dar um build no registro
        MongoClientOptions op = MongoClientOptions.builder().
                codecRegistry(registro).build();

        this.client = new MongoClient("localhost:27017", op);
        this.db = client.getDatabase("ZOOLOGICO");
    }

    public void salvar(Servico servico) {
        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        servicos.insertOne(servico);
        client.close();
    }

    public List<Servico> listarTodos() {
        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        MongoCursor<Servico> resultado = servicos.find().iterator();
        List<Servico> servicosLista = new ArrayList<>();

        while (resultado.hasNext()) {
            Servico servico = resultado.next();
            servicosLista.add(servico);
        }
        client.close();
        return servicosLista;
    }
    
    public List<Servico> listarTodosPendentes() {
        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        MongoCursor<Servico> resultado = servicos.find(new Document("concluido", false)).iterator();
        List<Servico> servicosLista = new ArrayList<>();

        while (resultado.hasNext()) {
            Servico servico = resultado.next();
            servicosLista.add(servico);
        }
        client.close();
        return servicosLista;
    }

    public int buscaUltimoID() {
        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        Servico servico = servicos.find().sort(descending("_id")).limit(1).first();
        client.close();
        if (servico != null) {
            return servico.getId();
        } else {
            return 0;
        }
    }
    
    public Servico buscarServico(int id) {
        Document filtro = new Document("_id", id);
        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        Servico funcionario = servicos.find(filtro).first();
        client.close();
        if (funcionario != null) {
            return funcionario;
        } else {
            return null;
        }
    }
    
    public Servico excluirServico(int id) {
        Document filtro = new Document("_id", id);
        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        Servico servico = servicos.findOneAndDelete(filtro);
        client.close();
        if (servico != null) {
            return servico;
        } else {            
            return null;
        }
    }
    
    public void salvarEdicao(Servico servicoEditado) {
        Document filtro = new Document("_id", servicoEditado.getId());
        int id = servicoEditado.getId();
        String nome = servicoEditado.getNome();
        String descricao = servicoEditado.getDescricao();
        int profissional = servicoEditado.getProfissional();
        int animal = servicoEditado.getAnimal();
        String data = servicoEditado.getData();
        boolean concluido = servicoEditado.isConcluido();

        Document doc = new Document("$set", new Document()
        .append("nome", nome)
        .append("descricao", descricao)
        .append("profissional", profissional)
        .append("animal", animal)
        .append("data", data)
        .append("concluido", concluido));

        conecta();
        MongoCollection<Servico> servicos = db.getCollection("servicos", Servico.class);
        servicos.updateOne(filtro, doc);
        client.close();
    }
}
