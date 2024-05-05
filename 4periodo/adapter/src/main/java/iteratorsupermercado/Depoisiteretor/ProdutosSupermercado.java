/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iteratorsupermercado.Depoisiteretor;

import iteratorsupermercado.*;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class ProdutosSupermercado {
    private ArrayList<Produto> produtosList;
    
    public ProdutosSupermercado(){
        produtosList = new ArrayList<Produto>();
        addProduto("Alface",  2.5);
        addProduto("Agrião", 3.00);
        addProduto("Laranja", 2.80);
        addProduto("Maçã", 4.5);
        addProduto("Tomate", 5.4);
    }
    
    public void addProduto(String descricao, double preco){
        Produto produto = new Produto(descricao, preco);
        produtosList.add(produto);
    }
    
    public ArrayList<Produto> getProduto(){
        return produtosList;
    }
    
    public Iterator createIterator(){
        return new SupermercadoIterator(produtosList);
    }
}
