/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iteratorsupermercado.Depoisiteretor;

/**
 *
 * @author vinic
 */
public class CafeteriaIterator implements Iterator{
    private  Produto[] produtos;
    private int index = 0;
    
    public CafeteriaIterator(Produto[] produtos){
        this.produtos = produtos;
    }
    
    @Override
    public boolean hasNext(){
        return index < produtos.length && produtos[index] != null;
    }
    
    @Override
    public Object next(){
        return produtos[index++];
    }
}
