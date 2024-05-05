/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategyFuncionarioDepois;

import singleton.SingletonLog;

/**
 *
 * @author vinic
 */
public class SalarioInexistente implements ISalario{
    @Override
    public void calcularSalario(){
        System.out.println("Salario inexistente!");
        SingletonLog.getInstance().doLog("Não foi realizado cálculo de salário!");
    }  
}
