/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactoryBancos;

/**s
 *
 * @author vinic
 */
public class RegrasBancoB implements IRegrasFactory{
    
    @Override
    public ICalculoJuros criaJuros() {
        return new CalculoJurosBancoB();
    }
    
    @Override
    public ICalculoDescontos criaDescontos(){
        return new CalculoDescontosBancoB();
    }

    @Override
    public ICalculoMultas criaMultas() {
        return new CalculoMultasBancoB();
    }
}
