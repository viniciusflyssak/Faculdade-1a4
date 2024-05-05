/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iteratorsupermercado;

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
        addProduto("Café", 3.00);
        addProduto("Bauru", 3.50);
        addProduto("Pão de queijo", 4.80);
        addProduto("Pastel", 2.5);
        addProduto("Bolo", 12.4);
    }
    
    public void addProduto(String descricao, double preco){
        Produto produto = new Produto(descricao, preco);
        if (index < MAX_PRODUTOS){
            lanches[index] = produto;
            index++;
        }
    }
    
    public Produto[] getProdutos(){
        return lanches;
    }
}
