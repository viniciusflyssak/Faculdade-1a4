/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author vinic
 */
public class Main {

    public static void main(String args[]) {
        ConcreteObserverBalanca balanca = new ConcreteObserverBalanca();
        ConcreteSubjectDieta dieta = new ConcreteSubjectDieta(60);
        dieta.registerObserver(balanca);
        dieta.setPeso(50);
        dieta.setPeso(90);
        dieta.setPeso(150);
    }
}
