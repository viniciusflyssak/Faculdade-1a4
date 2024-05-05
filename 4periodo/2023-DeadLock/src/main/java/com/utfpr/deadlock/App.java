/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinic
 */
public class App {
    public static void main(String[] args) {
        final String RECURSO1 = "Recurso 1";
        final String RECURSO2 = "Recurso 2";
        
        Thread t1;
        t1 = new Thread(){
            public void run(){
                System.out.println("A thread t1 está acessando o recurso 1");
                synchronized (RECURSO1){                    
                    System.out.println("Thread t1 acessou o recurso e esta bloqueando o recurso 1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                System.out.println("A thread t1 está acessando o recurso 2");
                synchronized (RECURSO2){
                    System.out.println("Thread t1 acessou o recurso e esta bloqueando o recurso 2");    
                }
            }
        };
        
        Thread t2;
        t2 = new Thread(){
            public void run(){
                System.out.println("A thread t2 está acessando o recurso 2");
                synchronized (RECURSO2){                    
                    System.out.println("Thread t2 acessou o recurso e esta bloqueando o recurso 2");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                System.out.println("A thread t2 está acessando o recurso 1");
                synchronized (RECURSO1){
                    System.out.println("Thread t2 acessou o recurso e esta bloqueando o recurso 1");    
                }
            }
        };
        t1.start();
        t2.start();
    }
}
