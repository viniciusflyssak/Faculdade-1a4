package com.utfpr.jogoxadrezfactory;

public class JogadaFactoryConcreto extends JogadaFactory{

    @Override
    protected Jogada createJogada(String jogada) {
        return switch(jogada){
            case "ATAQUE"-> new EstrategiaAtaque();
            case "DEFESA"-> new EstrategiaDefesa();
            default->null;
        };
    }
    
}
