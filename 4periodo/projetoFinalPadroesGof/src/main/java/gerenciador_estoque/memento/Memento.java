package gerenciador_estoque.memento;

import gerenciador_estoque.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final List<Produto> produtos;

    public Memento(List<Produto> produtos) {
        this.produtos = new ArrayList<>(produtos);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}