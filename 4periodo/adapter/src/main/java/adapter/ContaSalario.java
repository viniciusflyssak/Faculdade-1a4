/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author vinic
 */
public class ContaSalario implements IConta {
        
    @Override
    public void getSaldo(){
        System.out.println("Saldo da conta corrente");
    }
}
