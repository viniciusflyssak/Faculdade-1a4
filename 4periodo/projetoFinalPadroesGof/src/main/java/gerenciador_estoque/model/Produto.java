package gerenciador_estoque.model;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private int quantidadeAntiga;

    public void setQuantidadeAntiga(int quantidadeAntiga) {
        this.quantidadeAntiga = quantidadeAntiga;
    }

    public int getQuantidadeAntiga() {
        return quantidadeAntiga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidadeAntiga = this.quantidade;
        this.quantidade = quantidade;
    }

    public Produto() {
    }
}
