package com.utfpr.jogoxadrezsingleton;

public class CompetidorXadrezSingleton{
    public Jogada jogada;
    private static int numInstancias = 0;
    private int cont;
    private static CompetidorXadrezSingleton instancia;  

    public static CompetidorXadrezSingleton getInstancia() {
        if (instancia == null){
            instancia = new CompetidorXadrezSingleton();
        }
        return instancia;
    }
    
    private CompetidorXadrezSingleton(){
        cont = ++ numInstancias;
    }
    
    public void mudaEstrategia(Jogada jogada, String nome){
        this.jogada = jogada;
        System.out.println("Mudança de estratégia de jogada do competidor " + nome);
    }      
}
