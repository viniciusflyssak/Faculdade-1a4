package com.utfpr.jogoxadrezfactory;

public class EstrategiaAtaque implements Jogada{

    @Override
    public void moverPeca(String nomeJogador, String peca) {
        System.out.println("Jogador " + nomeJogador + " realiza jogada de ataque movendo " + '"' + peca + '"');
    }
    
}
