/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iteratorsupermercado.Depoisiteretor;

/**
 *
 * @author vinic
 */
public class Relatorio {
    
    public void imprimeProdutos(Iterator iterator, String descricao){
        System.out.println("==="+descricao+"===");
        while(iterator.hasNext()){
            Produto produto = (Produto) iterator.next();
            System.out.println(produto.getDescricao()+": "+
                    produto.getPreco());
        }
    }
}
