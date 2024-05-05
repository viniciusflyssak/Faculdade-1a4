/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategyFuncionarioAnterior;

import strategyFuncionarioDepois.Funcionario;

/**
 *
 * @author vinic
 */
public class Contratado extends Funcionario{
    @Override
    public void calcularSalario(){
        System.out.println("Salário contratado - Salário Fixo");
    }
}
