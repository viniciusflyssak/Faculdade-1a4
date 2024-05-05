/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facadeadvogado;

/**
 *
 * @author vinic
 */
public class AdvogadoFacade {
    public static final int CRIMINAL = 0;
    public static final int CIVIL = 1;
    
    public Processo getProcesso(int tipo){
        switch (tipo){
            case CRIMINAL:
                IJustica justicaCriminal = new JusticaCriminal();
                return justicaCriminal.getProcesso();
                
            case CIVIL: 
                IJustica justicaCivil = new JusticaCivil();
                return justicaCivil.getProcesso();
            default:
                return null;
        }
    }
}
