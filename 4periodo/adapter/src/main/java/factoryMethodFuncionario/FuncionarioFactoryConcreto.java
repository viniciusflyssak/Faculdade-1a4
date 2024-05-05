/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodFuncionario;

/**
 *
 * @author vinic
 */
public class FuncionarioFactoryConcreto extends FuncionarioFactory {
    public Funcionario createFuncionario(String tipo){
        return switch (tipo) {
            case "ESTAGIARIO" -> new Estagiario();
            case "CONTRATADO" -> new Contratado();
            case "FREELANCER" -> new Freelancer();
            case "HOMEOFFICE" -> new HomeOffice();
            case "VOLUNTARIO" -> new Voluntario();
            default -> null;            
        };
    }
    
}
