/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iteratorsupermercado;

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
        
        System.out.println("-------------PRODUTOS  SUPERMERCADO-------------");
        for(Produto p: produtos){
            System.out.println(p.getDescricao() + " - " + p.getPreco());
        }
        
        System.out.println("---------------PRODUTOS  CAFETERIA--------------");
        for(int i = 0; i< lanches.length; i++){
            Produto lanche = lanches[i];
            if(lanche != null){
                System.out.println(lanche.getDescricao() + " - " + lanche.getPreco());
            }
        }
    }
}
