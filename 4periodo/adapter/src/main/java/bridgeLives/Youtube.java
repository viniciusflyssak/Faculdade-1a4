/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class Youtube implements IPlatform{
    
    public Youtube(){
        configureRMTP();
        System.out.println("Youtube: Transmissão iniciada.");
    }
    
    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("Youtube: Configurando broadcasting");
    }
    
    @Override
    public void authToken(){
        System.out.println("Youtube: autorizado com sucesso");
    }
}
