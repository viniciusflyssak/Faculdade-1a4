package com.utfpr.jogoxadrezfactory;

public abstract class CompetidorXadrez{
    public Jogada jogada;

    public CompetidorXadrez(Jogada jogada) {
        this.jogada = jogada;
    }

    public void mudaEstrategia(Jogada jogada, String nome){
        this.jogada = jogada;
        System.out.println("Mudança de estratégia de jogada do competidor " + nome);
    }   
}
