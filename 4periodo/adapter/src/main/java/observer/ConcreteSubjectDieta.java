/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubjectDieta implements Subject {

    private List observers = new ArrayList();
    private double peso;

    public ConcreteSubjectDieta(double peso) {
        this.peso = peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        // Quando a alteração do peso ocorrer, esse é o momento correto para notificar os
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
        // Chama o método de atualização de todos os observers disponíveis.
        Observer obs;
        for (int i = 0; i < observers.size(); i++) {
            System.out.println("Notificando observers!");
            obs = (Observer) observers.get(i);
            obs.update(this.peso);
        }
    }
}
