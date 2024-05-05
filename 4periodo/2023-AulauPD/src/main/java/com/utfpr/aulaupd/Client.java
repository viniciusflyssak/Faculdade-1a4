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
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author vinic
 */
public class Client {
    private DatagramSocket socket;
    private InetAddress ip;
    private byte[] buffer;

    public Client(DatagramSocket socket, InetAddress ip) {
        this.socket = socket;
        this.ip = ip;
    }
    
    public void enviarReceber() throws IOException{
        Scanner scan = new Scanner(System.in);
        while(true){
            String msg = scan.nextLine();
            
            buffer = msg.getBytes();
            
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, ip, 8081);
            socket.send(datagram);
            
            //fica na espera de resposta
            socket.receive(datagram);
            
            String msgNova = new String(datagram.getData(),0, datagram.getLength());
            System.out.println("O servidor recebeu essa mensagem: " + msgNova);
        }
    }
    
    public static void main (String[] args) throws IOException, SocketException, UnknownHostException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        Client client = new Client(socket, ip);
        
        System.out.println("iniciando conversa com o servidor");
        client.enviarReceber();
    }
}
