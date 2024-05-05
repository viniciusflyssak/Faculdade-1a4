/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio3;

/**
 *
 * @author rubia
 */
//Objeto Real
public class RealSubject implements SubjectProxy {
    private String nome;
    private String id;
    private Boolean vip;
    
    public RealSubject(String id, String nome) {
        this.id = id;
        this.nome = nome;
        if (nome == "Valdemar") {
            this.vip = true;
        }else{
            this.vip = false;
        }
    }
    
    @Override
    public String validaVip() {
        if (this.vip) {
            return "Este passageiro é vip";
        }else{
            return "Este passageiro não é vip";
        }
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public Boolean getVip() {
        return vip;
    }
}
