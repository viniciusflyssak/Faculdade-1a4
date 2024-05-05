/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio3;


public class Proxy implements SubjectProxy {
    private String id;
    private SubjectProxy pessoa; 
    
    public Proxy(String id) {
        this.id = id;
    }
    
    @Override
    public String getNome() {
        if (pessoa == null) {
            pessoa = PassageiroDAO.getVipPassageiro(id);
        }
        return pessoa.getNome();
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public Boolean getVip() {
        return pessoa.getVip();
    }

    @Override
    public String validaVip() {
        return pessoa.validaVip();
    }
    
    
}
