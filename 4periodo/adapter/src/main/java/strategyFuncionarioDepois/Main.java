/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategyFuncionarioDepois;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
       Funcionario e = new Estagiario();
       e.calcularSalario();
       e.calcularFerias();
       
       Funcionario c = new Contratado();
       c.calcularSalario();
       c.calcularFerias();
       
       Funcionario h = new HomeOffice();
       h.calcularSalario();
       h.calcularFerias();
       
       Funcionario v = new Voluntario();
       v.calcularSalario();
       v.calcularFerias();       
       
       Funcionario f = new Freelancer();
       f.calcularSalario();
       f.calcularFerias();      
    }    
}
