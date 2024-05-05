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
public class SemFerias implements IFerias{
    @Override
    public void calcularFerias(){
        System.out.println("Não tem direito a férias!");
        SingletonLog.getInstance().doLog("Não foi calculado férias");
    } 
}
