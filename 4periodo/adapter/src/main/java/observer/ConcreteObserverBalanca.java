/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author vinic
 */
class ConcreteObserverBalanca implements Observer {
    public void update(double novoPeso) {
        if (novoPeso >= 100) {
            System.out.println("Você ultrapassou o peso limite no sistema!");
        }
    }
}
