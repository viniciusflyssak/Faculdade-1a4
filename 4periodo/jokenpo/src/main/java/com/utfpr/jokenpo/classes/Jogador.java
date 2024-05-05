package com.utfpr.jokenpo.classes;

import java.io.Serializable;

public class Jogador implements Serializable{
    private static final long serialVersionUID = 1L;
    private int pontuacao;
    private String nome;
    private char jogada;
    private boolean add;
    private boolean remove;
    private int sala;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador(String nome, boolean add, boolean remove, int sala) {
        this.nome = nome;
        this.add = add;
        this.remove = remove;
        this.sala = sala;
        this.pontuacao = 0;
        this.jogada = ' ';
        this.msg = "";
    }

    public char getJogada() {
        return jogada;
    }

    public void setJogada(char jogada) {
        this.jogada = jogada;
    }

    public Jogador() {
        this.nome = "";
        this.pontuacao = 0;
        this.jogada = ' ';
        this.msg = "";
    }
}
