/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractFactoryBancos;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        IRegrasFactory regras = new RegrasBancoA();
        ICalculoJuros juros = regras.criaJuros();
        ICalculoDescontos descontos = regras.criaDescontos();
        ICalculoMultas multas = regras.criaMultas();
        
        juros.exibirInfoJuros();
        descontos.exibirInfoDescontos();
        multas.exibirInfoMultas();
        
        regras = new RegrasBancoB();
        juros = regras.criaJuros();
        descontos = regras.criaDescontos();
        multas = regras.criaMultas();
        
        juros.exibirInfoJuros();
        descontos.exibirInfoDescontos();
        multas.exibirInfoMultas();
        
    }
}
