/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade1;

/**
 *
 * @author vinic
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Bancos de Dados MySQL:");
        IRegrasFactory regras = new RegrasMySql();
        IConnection connection = regras.criaConnection();
        ICommand command = regras.criaCommand();
        IParameter parameter = regras.criaParametros();

        connection.conectar();
        command.executaComando();
        parameter.configuraParametros();

        System.out.println("");
        System.out.println("Bancos de Dados SQLServer:");
        regras = new RegrasSqlServer();
        connection = regras.criaConnection();
        command = regras.criaCommand();
        parameter = regras.criaParametros();

        connection.conectar();
        command.executaComando();
        parameter.configuraParametros();

    }
}
