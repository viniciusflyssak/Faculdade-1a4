package com.utfpr.jogoxadrez;

public class EstrategiaDefesa implements Jogada{

    @Override
    public void moverPeca(String nomeJogador, String peca) {
        System.out.println("Jogador " + nomeJogador + " realiza jogada de defesa movendo " +'"' + peca +'"');
    }
    
}
