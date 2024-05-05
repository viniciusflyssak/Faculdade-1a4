/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade1;

/**
 *
 * @author vinic
 */
public class ConnectionMySql implements IConnection{

    @Override
    public void conectar() {
        System.out.println("Connection: Conexão com banco MySQL");
    }

    
}
