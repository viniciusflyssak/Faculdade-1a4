/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategyFuncionarioAnterior;

import strategyFuncionarioDepois.Contratado;
import strategyFuncionarioDepois.Estagiario;
import strategyFuncionarioDepois.Funcionario;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
       Funcionario e = new Estagiario();
       e.calcularSalario();
       
       Funcionario c = new Contratado();
       c.calcularSalario();
    }    
}
