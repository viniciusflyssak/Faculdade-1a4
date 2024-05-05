package com.utfpr.jogoxadrez;

public class Jogador extends CompetidorXadrez{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador(String nome, Jogada jogada) {
        super(jogada);
        this.nome = nome;
    }
    
    public void executarJogada(String peca){
        jogada.moverPeca(nome, peca);
    }
}
