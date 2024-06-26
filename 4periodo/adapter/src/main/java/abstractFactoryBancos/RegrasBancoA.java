/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactoryBancos;

/**
 *
 * @author vinic
 */
public class RegrasBancoA implements IRegrasFactory{
    
    @Override
    public ICalculoJuros criaJuros() {
        return new CalculoJurosBancoA();
    }
    
    @Override
    public ICalculoDescontos criaDescontos(){
        return new CalculoDescontosBancoA();
    }

    @Override
    public ICalculoMultas criaMultas() {
        return new CalculoMultasBancoA();
    }
}
