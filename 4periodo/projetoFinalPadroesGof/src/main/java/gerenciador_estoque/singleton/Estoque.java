package gerenciador_estoque.singleton;

import gerenciador_estoque.memento.Memento;
import gerenciador_estoque.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private static int numInstancias = 0;
    private final int cont;
    private final List<Produto> produtos = new ArrayList<>();
    private static Estoque instancia;

    private List<Memento> dadosAntigos = new ArrayList<>();

    private Estoque() {
        cont = ++numInstancias;
    }

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public Produto obterProduto(int id) {
        Produto produtoTemp = new Produto();
        produtos.forEach((prod) -> {
            if (prod.getId() == id) {
                produtoTemp.setId(prod.getId());
                produtoTemp.setNome(prod.getNome());
                produtoTemp.setQuantidade(prod.getQuantidade());
                produtoTemp.setQuantidadeAntiga(prod.getQuantidadeAntiga());
            }
        });
        return produtoTemp;
    }

    public void atualizaProduto(Produto produto) {
        produtos.forEach((prod) -> {
            if (prod.getId() == produto.getId()) {
                prod.setNome(produto.getNome());
                prod.setQuantidade(produto.getQuantidade());
                prod.setQuantidadeAntiga(produto.getQuantidadeAntiga());
            }
        });
    }

    public int qtdeProdutos() {
        return produtos.size();
    }

    public void listarProdutos() {
        produtos.forEach((produto) -> {
            System.out.println("Código: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Quantidade Atual: " + produto.getQuantidade());
            System.out.println("Quantidade Antiga: " + produto.getQuantidadeAntiga());
            System.out.println("");
        });
    }

    public void salvarDados() {
        List<Produto> estadoAtual = new ArrayList<>();
        produtos.forEach((prod) -> {
           Produto produtoTemp = new Produto();
           produtoTemp.setId(prod.getId());
           produtoTemp.setNome(prod.getNome());
           produtoTemp.setQuantidade(prod.getQuantidade());
           produtoTemp.setQuantidadeAntiga(prod.getQuantidadeAntiga());
           estadoAtual.add(produtoTemp);
        });
        Memento memento = new Memento(estadoAtual);
        dadosAntigos.add(memento);
        System.out.println("Dados salvos!");
    }

    public void voltarAnterior() {
        if (!dadosAntigos.isEmpty()) {
            Memento memento = dadosAntigos.remove(dadosAntigos.size() - 1);
            produtos.clear();
            produtos.addAll(memento.getProdutos());
            System.out.println("Dados carregados!");
        } else {
            System.out.println("Não existem dados para carregar!");
        }
    }
}
