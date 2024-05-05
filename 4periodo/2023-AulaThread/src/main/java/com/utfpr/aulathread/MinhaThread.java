/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulathread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinic
 */
public class MinhaThread implements Runnable{
    private String nome;
    private int tempo;
//    private Thread t;

    public MinhaThread(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
//        t = new Thread(this);
//        t.start();
    }    
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(nome + " esta contando segundos: " +i);
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
//        if (t.isAlive()){
//            System.out.println(nome + " acabou");
//        }
    }
}
