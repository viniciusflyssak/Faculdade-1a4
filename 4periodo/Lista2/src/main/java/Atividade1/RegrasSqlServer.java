/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade1;

/**s
 *
 * @author vinic
 */
public class RegrasSqlServer implements IRegrasFactory{

    @Override
    public IParameter criaParametros() {
        return new ParameterSqlServer();
    }

    @Override
    public IConnection criaConnection() {
        return new ConnectionSqlServer();
    }

    @Override
    public ICommand criaCommand() {
        return new CommandSqlServer();
    }

}
