/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodFuncionario;
import singleton.SingletonLog;

/**
 *
 * @author vinic
 */
public class SalarioComissao implements ISalario{
    @Override
    public void calcularSalario(){
        System.out.println("Salario comissão");
        SingletonLog.getInstance().doLog("Cálculo de Salário por comissão");
    }      
}
