/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodFuncionario;

/**
 *
 * @author vinic
 */
public abstract class FuncionarioFactory {
    protected abstract Funcionario createFuncionario(String tipo);
    
    public Funcionario fazerPagamento(String tipo) {
        Funcionario funcionario = createFuncionario(tipo);
        funcionario.calcularSalario();
        funcionario.calcularFerias();
        return funcionario;
    }
    
}
