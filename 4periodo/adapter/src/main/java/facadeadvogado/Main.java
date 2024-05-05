/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facadeadvogado;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        AdvogadoFacade advogado = new AdvogadoFacade();
        Processo pCivil = advogado.getProcesso(AdvogadoFacade.CIVIL);
        System.out.println("Civil: " + pCivil.getDescricao());
        Processo pCriminal = advogado.getProcesso(AdvogadoFacade.CRIMINAL);
        System.out.println("Criminal: " + pCriminal.getDescricao());
    }
   
}
