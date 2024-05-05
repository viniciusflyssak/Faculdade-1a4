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
public class App {
    public static void main(String[] args) {
        MinhaThread thread1 = new MinhaThread("Um", 200);
        MinhaThread thread2 = new MinhaThread("dois", 200);
        MinhaThread thread3 = new MinhaThread("três", 200);
        
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread2);
               
        t1.start();
        t2.start();
        t3.start();
        
        //10 é a prioridade máxima
        t1.setPriority(Integer.MAX_VALUE);
        t2.setPriority(Integer.MIN_VALUE);
        t3.setPriority(1);
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }                      
        System.out.println("Acabou");
    }
}
