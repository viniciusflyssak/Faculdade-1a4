/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade1;

/**
 *
 * @author vinic
 */
public class RegrasMySql implements IRegrasFactory{

    @Override
    public IParameter criaParametros() {
        return new ParameterMySql();
    }

    @Override
    public IConnection criaConnection() {
        return new ConnectionMySql();
    }

    @Override
    public ICommand criaCommand() {
        return new CommandMySql();
                
    }

}
