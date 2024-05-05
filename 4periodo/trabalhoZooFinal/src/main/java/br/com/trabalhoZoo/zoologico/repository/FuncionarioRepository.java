package br.com.trabalhoZoo.zoologico.repository;

import br.com.trabalhoZoo.zoologico.codec.FuncionarioCodec;
import br.com.trabalhoZoo.zoologico.model.Funcionario;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Indexes.descending;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioRepository {

    private MongoClient client;
    private MongoDatabase db;

    public void conecta() {
        //Instaciar um codec
        Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);

        //Qual classe ira sofrer o encode/decode
        FuncionarioCodec FuncionarioCodec = new FuncionarioCodec(codec);

        //Instanciar um registro para o codec
        CodecRegistry registro = CodecRegistries
                .fromRegistries(MongoClient.getDefaultCodecRegistry(),
                        CodecRegistries.fromCodecs(FuncionarioCodec));

        //Dar um build no registro
        MongoClientOptions op = MongoClientOptions.builder().
                codecRegistry(registro).build();

        this.client = new MongoClient("localhost:27017", op);
        this.db = client.getDatabase("ZOOLOGICO");
    }

    public void salvar(Funcionario Funcionario) {
        conecta();
        MongoCollection<Funcionario> funcionarios = db.getCollection("funcionarios", Funcionario.class);
        funcionarios.insertOne(Funcionario);
        client.close();
    }

    public List<Funcionario> listarTodos() {
        conecta();
        MongoCollection<Funcionario> funcionarios = db.getCollection("funcionarios", Funcionario.class);
        MongoCursor<Funcionario> resultado = funcionarios.find().iterator();
        List<Funcionario> funcionariosLista = new ArrayList<>();

        while (resultado.hasNext()) {
            Funcionario funcionario = resultado.next();
            funcionariosLista.add(funcionario);
        }
        client.close();
        return funcionariosLista;
    }

    public int buscaUltimoID() {
        conecta();
        MongoCollection<Funcionario> funcionarios = db.getCollection("funcionarios", Funcionario.class);
        Funcionario funcionario = funcionarios.find().sort(descending("_id")).limit(1).first();
        client.close();
        if (funcionario != null) {
            return funcionario.getId();
        } else {
            return 0;
        }

    }
    
    public Funcionario buscarFuncionario(int id) {
        Document filtro = new Document("_id", id);
        conecta();
        MongoCollection<Funcionario> funcionarios = db.getCollection("funcionarios", Funcionario.class);
        Funcionario funcionario = funcionarios.find(filtro).first();
        client.close();
        if (funcionario != null) {
            return funcionario;
        } else {            
            return null;
        }
    }
    
    public Funcionario excluirFuncionario(int id) {
        Document filtro = new Document("_id", id);
        conecta();
        MongoCollection<Funcionario> funcionarios = db.getCollection("funcionarios", Funcionario.class);
        Funcionario funcionario = funcionarios.findOneAndDelete(filtro);
        client.close();
        if (funcionario != null) {
            return funcionario;
        } else {            
            return null;
        }
    }
    
    public void salvarEdicao(Funcionario funcionarioEditado) {
        Document filtro = new Document("_id", funcionarioEditado.getId());
        int id = funcionarioEditado.getId();
        String nome = funcionarioEditado.getNome();
        String profissao = funcionarioEditado.getProfissao();
        String sexo = funcionarioEditado.getSexo();
        String cpf = funcionarioEditado.getCpf();
        String email = funcionarioEditado.getEmail();

        Document doc = new Document("$set", new Document()
       .append("nome", nome)
       .append("profissao", profissao)
       .append("sexo", sexo)
       .append("cpf", cpf)
        .append("email", email));
        conecta();
        MongoCollection<Funcionario> funcionarios = db.getCollection("funcionarios", Funcionario.class);
        funcionarios.updateOne(filtro, doc);
        client.close();
    }
}
