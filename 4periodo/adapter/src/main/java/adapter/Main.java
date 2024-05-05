/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        IConta c1 = new ContaSalario();
        IConta c2 = new ContaCorrente();
        IConta c3 = new PoupancaAdapter (new ContaPoupanca());
        c1.getSaldo();
        c2.getSaldo();
        c3.getSaldo();
    }    
}
