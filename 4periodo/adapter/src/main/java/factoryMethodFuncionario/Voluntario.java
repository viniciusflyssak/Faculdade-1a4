/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodFuncionario;

/**
 *
 * @author vinic
 */
public class Voluntario extends Funcionario{
    public Voluntario() {
        salario = new SalarioInexistente();
        ferias = new SemFerias();
    }  
}
