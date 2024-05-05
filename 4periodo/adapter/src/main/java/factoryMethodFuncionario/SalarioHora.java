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
public class SalarioHora implements ISalario{
    @Override
    public void calcularSalario(){
        System.out.println("Salario por hora");
        SingletonLog.getInstance().doLog("Cálculo de Salário por hora");
    }
    
}
