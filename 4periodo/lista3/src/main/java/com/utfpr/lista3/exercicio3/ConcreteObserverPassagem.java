/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio3;

/**
 *
 * @author vinic
 */
public class ConcreteObserverPassagem implements Observer {
    public void update(double valorNovo, double valorAntigo) {
        if (valorNovo < valorAntigo) {
            System.out.println("Passagem diminuiu valor para " + valorNovo + " reais.");
        }
    }
}
