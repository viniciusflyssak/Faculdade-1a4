/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class Facebook implements IPlatform{
    
    public Facebook(){
        configureRMTP();
        System.out.println("Facebook: Transmissão iniciada.");
    }
    
    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("Facebook: Configurando broadcasting");
    }
    
    @Override
    public void authToken(){
        System.out.println("Facebook: autorizado com sucesso");
    }
}
