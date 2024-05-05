package com.utfpr.strategyjogo;

public class Main {
    public static void main(String[] args){
        System.out.println("Jogador usa teclado");
        ControleJogo controleJogo = new ControleJogo();
        controleJogo.mudaControle(new EstrategiaTeclado());
        System.out.println("");
        
        System.out.println("Jogador usa joystick");
        controleJogo.mudaControle(new EstrategiaJoystick());
        System.out.println("");
                 
        System.out.println("Jogador usa gesto");
        controleJogo.mudaControle(new EstrategiaGesto());
    }    
}
