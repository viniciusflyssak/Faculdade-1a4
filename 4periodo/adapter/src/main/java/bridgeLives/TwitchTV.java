/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class TwitchTV implements IPlatform{
    
    public TwitchTV(){
        configureRMTP();
        System.out.println("TwitchTV: Transmissão iniciada.");
    }
    
    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("TwitchTV: Configurando broadcasting");
    }
    
    @Override
    public void authToken(){
        System.out.println("TwitchTV: autorizado com sucesso");
    }
}
