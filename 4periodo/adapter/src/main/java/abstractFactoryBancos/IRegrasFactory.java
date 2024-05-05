/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactoryBancos;

/**
 *
 * @author vinic
 */
interface IRegrasFactory {
    ICalculoJuros criaJuros();
    ICalculoDescontos criaDescontos();
    ICalculoMultas criaMultas();
}
