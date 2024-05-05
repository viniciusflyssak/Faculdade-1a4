package com.utfpr.jogoxadrez;

public class Main {
    public static void main(String[] args) {
        Jogador fulano = new Jogador("Fulano", new EstrategiaAtaque());
        Jogador ciclano = new Jogador("Ciclano", new EstrategiaDefesa());
        
        fulano.executarJogada("Peão");
        ciclano.executarJogada("Torre");
        
        fulano.mudaEstrategia(new EstrategiaDefesa(), fulano.getNome());
        
        fulano.executarJogada("Cavalo");
        
        ciclano.mudaEstrategia(new EstrategiaAtaque(), ciclano.getNome());
        
        ciclano.executarJogada("Bispo");
    }
}
