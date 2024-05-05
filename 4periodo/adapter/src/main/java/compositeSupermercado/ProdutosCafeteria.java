/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compositeSupermercado;

/**
 *
 * @author vinic
 */
public class ProdutosCafeteria {
    static final int MAX_PRODUTOS = 5;
    int index = 0;
    Produto[] lanches;
    
    public ProdutosCafeteria(){
        lanches = new Produto[MAX_PRODUTOS];
        addProduto("Café", 3.00, "Bebidas");
        addProduto("Bauru", 3.50, "Salgados");
        addProduto("Pão de queijo", 4.80, "Salgados");
        addProduto("Pastel", 2.5, "Salgados");
        addProduto("Bolo", 12.4, "Doces");
    }
    
    public void addProduto(String descricao, double preco, String setor){
        Produto produto = new Produto(descricao, preco, setor);
        if (index < MAX_PRODUTOS){
            lanches[index] = produto;
            index++;
        }
    }
    
    public Produto[] getProdutos(){
        return lanches;
    }
    
    public Iterator createIterator(){
        return new CafeteriaIterator(lanches);
    }
}
