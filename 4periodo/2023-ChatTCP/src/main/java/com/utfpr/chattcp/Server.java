/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.chattcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vinic
 */
public class Server {
    private ServerSocket socket;
    public Server(ServerSocket socket) {
        this.socket = socket;
    }
    public void iniciarSessao() throws IOException{
        while(!socket.isClosed()){
            Socket conexao = socket.accept();
            System.out.println("Um cliente se conectou!");
            Gerenciador gerenciadorCliente = new Gerenciador(conexao);
            Thread t = new Thread(gerenciadorCliente);
            t.start();
        }
    }
    
    public void encerrar() throws IOException{
        if(socket != null){
            socket.close();
        }
    }
    
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8081);
        Server servidor = new Server(server);
        System.out.println("servidor iniciado com sucesso!");
        servidor.iniciarSessao();
    }
    
}
