/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.trabalhoZoo.zoologico.model;

/**
 *
 * @author vinic
 */
public class ServicoRelat {

    private String servico;
    private String profissional;
    private String animal;
    private String concluido;
    private String data;

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getConcluido() {
        return concluido;
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ServicoRelat(String servico, String profissional, String animal, String concluido, String data) {
        this.servico = servico;
        this.profissional = profissional;
        this.animal = animal;
        this.concluido = concluido;
        this.data = data;
    }

    public ServicoRelat() {
    }

    
}
