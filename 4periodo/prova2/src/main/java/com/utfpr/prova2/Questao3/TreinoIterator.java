/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao3;

/**
 *
 * @author vinic
 */
public class TreinoIterator implements Iterator{
    private Exercicio[] exercicios;
    private int index = 0;

    public TreinoIterator(Exercicio[] exercicios) {
        this.exercicios = exercicios;
    }

    @Override
    public boolean hasNext() {
        return index < exercicios.length && exercicios[index] != null;
    }

    @Override
    public Object next() {
        return exercicios[index++];
    }
    
    
}
