/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.chattcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinic
 */
public class Client {
    private Socket socket;
    private String userName;
    private BufferedReader receber;
    private BufferedWriter enviar;
    
    public Client(Socket socket, String userName) throws IOException {
        try {
            this.socket = socket;
            this.userName = userName;
            this.receber = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.enviar = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
        } catch (IOException e) {
            fechar(socket, receber, enviar);
        }    
    }
    
    public void fechar(Socket socket, BufferedReader receber, BufferedWriter envia) throws IOException{
        try{
            if(socket != null){
                socket.close();
            }

            if(receber != null){
                receber.close();
            }

            if (envia != null){
                envia.close();
            }
        }catch (IOException e){
            fechar(socket, receber, enviar);
        }        
    }
    
    public void receber(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                String mensagemRecebida;
                while(socket.isConnected()){
                    try {
                        mensagemRecebida = receber.readLine();
                        System.err.println(mensagemRecebida);
                    } catch (Exception e) {
                        try {
                            fechar(socket, receber, enviar);
                        } catch (IOException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }).start();
    }
    
    public void enviar() throws IOException{
        try{
            enviar.write(userName);
            enviar.newLine();
            enviar.flush();
            Scanner scanner = new Scanner(System.in);
            while(socket.isConnected()){
                String msg = scanner.nextLine();
                enviar.write(userName + ": " + msg);
                enviar.newLine();
                enviar.flush();
            }
        }catch (IOException e){
            fechar(socket, receber, enviar);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do seu usuário!");
        String nome = scanner.nextLine();
        
        Socket socket = new Socket("localhost", 8081);
        Client cliente = new Client(socket, nome);
        
        cliente.receber();
        cliente.enviar();
    }
            
            
            
}
