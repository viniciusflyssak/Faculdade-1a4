/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.chattcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinic
 */
class Gerenciador implements Runnable{

    public static ArrayList<Gerenciador> clientes = new ArrayList<>();
    
    private Socket socket;
    private BufferedReader receber;
    private BufferedWriter enviar;
    private String userName;

    public Gerenciador(Socket socket) throws IOException {
        try {
            this.socket = socket;
            this.receber = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.enviar = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.userName = receber.readLine();
            clientes.add(this);

            transmitir("servidor: " + userName + " se conectou!");
        } catch (Exception e) {
            fechar(socket, receber, enviar);
        }        
    }
    
    public void transmitir(String mensagem) throws IOException{
        for (Gerenciador cliente: clientes) {
            if(!cliente.userName.equals(userName)){
                cliente.enviar.write(mensagem);
                cliente.enviar.newLine();
                cliente.enviar.flush();
            }
        }
    }
    
    public void removerCliente() throws IOException{
        clientes.remove(this);
        transmitir(userName + " saiu.");
    }
    
    public void fechar(Socket socket, BufferedReader receber, BufferedWriter envia) throws IOException{
        removerCliente();
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
    
    @Override
    public void run() {
        String mensagem;
        while(socket.isConnected()){
        try {
            mensagem = receber.readLine();
            transmitir(mensagem);
        } catch (IOException e) {
            try {
                fechar(socket, receber, enviar);
            } catch (IOException ex) {
                Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
}
