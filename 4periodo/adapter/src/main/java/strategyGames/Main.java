/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategyGames;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Dragão verde avistado a frente!");
        ExterminadorDragoes exterminador = new ExterminadorDragoes(new EstrategiaArmaBranca());
        exterminador.iniciarBatalha();
        
        System.out.println("Dragão vermelho emerge!");
        exterminador.mudaEstrategia(new EstrategiaDeProjetil());
        exterminador.iniciarBatalha();
                 
        System.out.println("Dragão negro pousa diante de você!");
        exterminador.mudaEstrategia(new EstrategiaFeitico());
        exterminador.iniciarBatalha();
    }
    
}
