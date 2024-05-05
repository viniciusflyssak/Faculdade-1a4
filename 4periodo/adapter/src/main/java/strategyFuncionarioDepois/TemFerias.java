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
public class TemFerias implements IFerias{
    @Override
    public void calcularFerias(){
        System.out.println("Tem direito a férias!");
        SingletonLog.getInstance().doLog("Cálculo de ferias realizado!");
    } 
    
}
