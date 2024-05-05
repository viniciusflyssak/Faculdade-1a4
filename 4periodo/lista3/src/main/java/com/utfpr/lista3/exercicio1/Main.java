/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio1;

/**
 *
 * @author vinic
 */
public class Main {

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
    }
}
