package com.utfpr.jogoxadrezfactory;

public class Main {
    public static void main(String[] args) {
        JogadaFactoryConcreto fabrica = new JogadaFactoryConcreto();
        Jogador fulano = new Jogador("Fulano", fabrica.createJogada("ATAQUE"));
        Jogador ciclano = new Jogador("Ciclano", fabrica.createJogada("DEFESA"));
        
        fulano.executarJogada("Peão");
        ciclano.executarJogada("Torre");
        
        fulano.mudaEstrategia(fabrica.createJogada("DEFESA"), fulano.getNome());
        
        fulano.executarJogada("Cavalo");
        
        ciclano.mudaEstrategia(fabrica.createJogada("ATAQUE"), ciclano.getNome());
        
        ciclano.executarJogada("Bispo");
    }
}
