/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.semaforothread;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author vinic
 */
public class App {
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        Carros carro1 = new Carros(1, 1982, "fusca");
        Carros carro2 = new Carros(2, 2003, "gol");
        Carros carro3 = new Carros(3, 2006, "corolla");
        Carros carro4 = new Carros(4, 2012, "punto");
        Carros carro5 = new Carros(5, 2008, "civic");
        Carros carro6 = new Carros(6, 2008, "bora");
        Carros carro7 = new Carros(7, 2016, "jetta");
        Carros carro8 = new Carros(8, 2013, "lancer");
        Carros carro9 = new Carros(9, 1998, "new Beetle");
        Carros carro10 = new Carros(10, 2002, "X1");
        Carros carro11 = new Carros(11, 1994, "vectra");
        Carros carro12 = new Carros(12, 2001, "astra");
        Carros carro13 = new Carros(13, 2016, "saveiro");
        Carros carro14 = new Carros(14, 2005, "santana");
        Carros carro15 = new Carros(15, 1998, "F1");
        
        Queue<Carros> carros = new LinkedList<>();
        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);
        carros.add(carro4);
        carros.add(carro5);
        carros.add(carro6);
        carros.add(carro7);
        carros.add(carro8);
        carros.add(carro9);
        carros.add(carro10);
        carros.add(carro11);
        carros.add(carro12);
        carros.add(carro13);
        carros.add(carro14);
        carros.add(carro15);
        for (int i = 0; i < 15; i++){
            System.out.println("Sinal esta: " + semaforo.getSinal());
            while(semaforo.getSinal().equals("verde")){
                if(!carros.isEmpty()){
                    System.out.println("Carros em movimento...");
                    semaforo.verificaPotencia(carros.element().getAno());
                    System.out.println("O " + carros.poll().getModelo() + " saiu");
                }else{
                    break;
                }
            }
            semaforo.tempoSinal();            
        }
        semaforo.desligar();
    }
}
