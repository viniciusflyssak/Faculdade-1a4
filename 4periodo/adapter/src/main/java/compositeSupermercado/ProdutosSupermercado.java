/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compositeSupermercado;

import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class ProdutosSupermercado {
    private ArrayList<Produto> produtosList;
    
    public ProdutosSupermercado(){
        produtosList = new ArrayList<Produto>();
        addProduto("Alface",  2.5, "Verduras");
        addProduto("Agrião", 3.00, "Verduras");
        addProduto("Laranja", 2.80, "Frutas");
        addProduto("Maçã", 4.5, "Frutas");
        addProduto("Tomate", 5.4, "Orgânicas");
    }
    
    public void addProduto(String descricao, double preco, String setor){
        Produto produto = new Produto(descricao, preco, setor);
        produtosList.add(produto);
    }
    
    public ArrayList<Produto> getProduto(){
        return produtosList;
    }
    
    public Iterator createIterator(){
        return new SupermercadoIterator(produtosList);
    }
}
