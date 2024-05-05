/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodFuncionario;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
       System.out.println("Exemplo factory method");
       FuncionarioFactory fabrica = new FuncionarioFactoryConcreto();
       
       System.out.println("estagiário");
       Funcionario e = fabrica.fazerPagamento("ESTAGIARIO");
       
       System.out.println("contratado");
       Funcionario c = fabrica.fazerPagamento("CONTRATADO");
       
       System.out.println("home office");
       Funcionario h = fabrica.fazerPagamento("HOMEOFFICE");
       
       System.out.println("voluntario");
       Funcionario v = fabrica.fazerPagamento("VOLUNTARIO");
       
       System.out.println("freelancer");
       Funcionario f = fabrica.fazerPagamento("FREELANCER");
    }    
}
