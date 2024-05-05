/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class Instagram implements IPlatform{
    
    public Instagram(){
        configureRMTP();
        System.out.println("Instagram: Transmissão iniciada.");
    }
    
    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("Instagram: Configurando broadcasting");
    }
    
    @Override
    public void authToken(){
        System.out.println("Instagram: autorizado com sucesso");
    }
}
