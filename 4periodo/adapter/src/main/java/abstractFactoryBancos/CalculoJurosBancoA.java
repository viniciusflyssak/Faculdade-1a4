/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactoryBancos;

/**
 *
 * @author vinic
 */
public class CalculoJurosBancoA implements ICalculoJuros{

    @Override
    public void exibirInfoJuros() {
        System.out.println("Juros Banco A: 8% ao ano.");
    }
    
}
