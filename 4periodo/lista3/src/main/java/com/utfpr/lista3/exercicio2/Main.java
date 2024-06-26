/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio2;

/**
 *
 * @author vinic
 */
public class Main {

    protected static void construir(Builder construtor, Lanche lanche) {
        construtor.construirLanche(lanche);
    }
   
    public static void main(String args[]) {
        ConcreteObserverPassagem interessado1 = new ConcreteObserverPassagem();
        ConcreteObserverPassagem interessado2 = new ConcreteObserverPassagem();
        ConcreteObserverPassagem interessado3 = new ConcreteObserverPassagem();
        ConcreteSubjectPassagem valorPassagem = new ConcreteSubjectPassagem(100);
        System.out.println("Valor da passagem definido para 100 reais");
        valorPassagem.registerObserver(interessado1);
        valorPassagem.registerObserver(interessado2);
        valorPassagem.registerObserver(interessado3);
        valorPassagem.setValor(50);
        valorPassagem.setValor(110);
        valorPassagem.setValor(30);
                
        Builder constLancheComum = new ConcreteBuilder_LancheComum();
        Builder constLancheVegano = new ConcreteBuilder_LancheVegano();
        Lanche lanche = new Lanche("Lanche");
        construir(constLancheComum, lanche);
        construir(constLancheVegano, lanche);
        System.out.println(constLancheComum.obterResultado());
        System.out.println(constLancheVegano.obterResultado());
    
    }
}
