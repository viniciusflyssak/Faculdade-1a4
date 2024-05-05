package com.utfpr.trabalho_zoo.model;

import com.utfpr.trabalho_zoo.repositorys.ServicoRepository;

public class Servico {

    private int id;
    private String nome;
    private String descricao;
    private String data;
    private int animal;
    private int profissional;
    private boolean concluido;

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAnimal() {
        return animal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getProfissional() {
        return profissional;
    }

    public void setProfissional(int profissional) {
        this.profissional = profissional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Servico criaId() {
        ServicoRepository servicoRepository = new ServicoRepository();
        setId(servicoRepository.buscaUltimoID() + 1);
        return this;
    }
}
