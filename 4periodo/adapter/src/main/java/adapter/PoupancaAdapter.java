/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author vinic
 */
public class PoupancaAdapter implements IConta{
    ContaPoupanca poupanca;
    
    public PoupancaAdapter(ContaPoupanca poupanca){
        this.poupanca = poupanca;
    }
    
    @Override
    public void getSaldo(){
        poupanca.valorAcumulado();
    }
}
