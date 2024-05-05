/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iteratorsupermercado.Depoisiteretor;

import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class SupermercadoIterator implements Iterator{
    private ArrayList<Produto> produtos;
    private int index = 0;

    public SupermercadoIterator(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean hasNext() {
        return index < produtos.size() && produtos.get(index) != null;
    }

    @Override
    public Object next() {
        return produtos.get(index++);
    }
    
    
}
