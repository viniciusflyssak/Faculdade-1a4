/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactoryBancos;

/**
 *
 * @author vinic
 */
public class CalculoDescontosBancoA implements ICalculoDescontos{

    @Override
    public void exibirInfoDescontos() {
        System.out.println("Descontos Banco A: 13% à vista");
    }
    
}
