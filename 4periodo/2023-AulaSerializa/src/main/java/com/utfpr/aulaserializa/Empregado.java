/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulaserializa;

import java.io.Serializable;

/**
 *
 * @author vinic
 */
public class Empregado implements Serializable{
    String nome;
    String rua;
    int num;
    transient int cpf;

    public Empregado(String nome, String rua, int num, int cpf) {
        this.nome = nome;
        this.rua = rua;
        this.num = num;
        this.cpf = cpf;
    }
    
    public void correspondencia(){
        System.out.println("Enviando uma correspondência para: "+nome+" na rua: " +rua+" no número: "+num);
    }
}
