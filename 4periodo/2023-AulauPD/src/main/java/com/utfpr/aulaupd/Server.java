/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulaupd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author vinic
 */
public class Server {
    private DatagramSocket socket;

    public Server(DatagramSocket socket) {
        this.socket = socket;
    }
    private byte [] buffer = new byte[256];
    public void receberEnviar() throws IOException{
        String nome;
        String RA;
        
        while(true){
            // um pacote de datagramas é usado para enviar mensagens não orientada a conexão
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
            
            socket.receive(datagram);//todo pacote recebido por uma datagramsocket é endereçado e transportado de forma individual            
            
            InetAddress ip = datagram.getAddress();
            int port = datagram.getPort();
            
            String msg = new String(buffer,0, buffer.length);
            System.out.println("Mensagem recebida" + msg);
            
            datagram = new DatagramPacket(buffer, buffer.length, ip, port);
            
            socket.send(datagram);
        }
    }
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket socket = new DatagramSocket(8081);
        Server server = new Server(socket);
        System.out.println("Subindo o servidor...");
        server.receberEnviar();
    }
    
}
