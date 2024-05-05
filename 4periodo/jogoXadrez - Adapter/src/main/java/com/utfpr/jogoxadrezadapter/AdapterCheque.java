package com.utfpr.jogoxadrezadapter;

public class AdapterCheque implements Jogada{
    EstrategiaCheque estrategiaCheque;

    public AdapterCheque(EstrategiaCheque estrategiaCheque) {
        this.estrategiaCheque = estrategiaCheque;
    }
    
    @Override
    public void moverPeca(String nomeJogador, String peca) {
        this.estrategiaCheque.executaCheque(nomeJogador, peca);
    }
}
