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
public class Main {
    public static void main(String[] args) {
        ProdutosSupermercado produtosList = new ProdutosSupermercado();
        ArrayList<Produto> produtos = produtosList.getProduto();
        
        ProdutosCafeteria lanchesList = new ProdutosCafeteria();
        Produto[] lanches = lanchesList.getProdutos();
        
        //Uso do padrão iterator para percorrer os produtos dos conjuntos implementados de formas diferentes
        Relatorio relatorio = new Relatorio();
        relatorio.imprimeProdutos(new ProdutosSupermercado().createIterator(), "PRODUTOS SUPERMERCADO");
        relatorio.imprimeProdutos(new ProdutosCafeteria().createIterator(), "PRODUTOS CAFETERIA");
    }
}
