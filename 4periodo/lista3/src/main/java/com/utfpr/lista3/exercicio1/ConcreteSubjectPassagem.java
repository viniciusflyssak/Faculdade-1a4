/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubjectPassagem implements Subject {

    private List observers = new ArrayList();
    private double valor;
    private double valorAntigo;

    public double getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(double valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public ConcreteSubjectPassagem(double valor) {
        this.valor = valor;
    }

    public void setValor(double valor) {
        this.valorAntigo = this.valor;
        this.valor = valor;
        this.notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Observer obs;
        for (int i = 0; i < observers.size(); i++) {
            System.out.println("Notificando interessado número " + (i + 1));
            obs = (Observer) observers.get(i);
            obs.update(this.valor, this.valorAntigo);
        }
    }
}
