/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategyFuncionarioDepois;

/**
 *
 * @author vinic
 */
public class Freelancer extends Funcionario{
    public Freelancer() {
        salario = new SalarioComissao();
        ferias = new SemFerias();
    }
}
