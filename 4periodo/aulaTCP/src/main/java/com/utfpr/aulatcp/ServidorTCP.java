/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulatcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vinic
 */
public class ServidorTCP {
    
    public static void main(String[] args) throws IOException
    {
        //Iniciar servidor, necessita de uma porta para ficar ouvindo as solicitaçòes
        ServerSocket servidor =  new ServerSocket(8081);
        
        System.out.println("Servidor na porta 8081");
        
        //Ficar no aguardo de alguma solicitação do lado dos clientes
        Socket socket = servidor.accept();
        
        //imprime o ip dos clientes ao conectar
        System.out.println("o cliente ip: " + socket.getInetAddress().getHostAddress() + " se conectou!");
        
        //Definir um stream de entrada de dados no servidor
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
                
        //Por padrão, o próprio Stream(socket) Java serializa as informações
        String mensagem = entrada.readUTF();
        
        //o servidor tem a função de converer string(char) para maiúsculo
        String novaMensagem = mensagem.toUpperCase();
        
        //Definir Stream de saída para os dados enviados para o cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        
        saida.writeUTF(novaMensagem);
        
        //fecho minhas strams de entrada e saída com os clientes
        entrada.close();
        saida.close();
        
        //Fecho a conexão
        socket.close();
        servidor.close();
    }
    
}
