package com.utfpr.jogoxadrezadapter;

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
        
        ciclano.mudaEstrategia(new AdapterCheque(new EstrategiaCheque()), ciclano.getNome());
        ciclano.executarJogada("Rainha");
    }
    
    // Sobre o adapter, foi criado para a "EstrategiaCheque", onde a mesma só possui o método 
    // "executaCheque", não sendo possível passar para o tipo "Jogada". Nesse caso, para que isso pudesse acontecer, 
    // fora criado o adapter "AdapterCheque", que converte o método "executaCheque" em "moverPeca", adaptando e tornando-o assim, 
    // compatível.
}
