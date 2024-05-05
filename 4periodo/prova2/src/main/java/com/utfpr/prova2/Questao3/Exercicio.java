/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao3;

/**
 *
 * @author vinic
 */
public class Exercicio extends ComponentesSetor{
    public String descricao;
    String setor;

    public Exercicio(String descricao, String setor) {
        this.descricao = descricao;
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    @Override
    public void print(String ident){
        System.out.println(ident+getDescricao());
    }
}
