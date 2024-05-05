/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulatcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author vinic
 */
public class ClienteTCP{
    public static void main(String[] args) throws IOException{
        //Abrir conexão via socket
        Socket socket = new Socket("127.0.0.1", 8081);
        
        //Definir um stream de saída de dados
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        
        //Serealização de dados
        saida.writeUTF("querido servidor");
        
        //Definir um stream de entrada de dados do servidor
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        
        //Deserialização de dados
        String novaMensagem = entrada.readUTF();
        
        System.out.println(novaMensagem);
        
        //Fecha entradas e saídas de dados
        entrada.close();
        saida.close();
        
        //Fecha socket
        socket.close();
    }
    
}
