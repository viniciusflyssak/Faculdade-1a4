/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class AdvancedLive extends Live {
    public AdvancedLive(IPlatform platform){
        super.platform = platform;
    }
    
    public void subtitles(){
        System.out.println("Legenda ativada na transmissão.");
    }
    
    public void comments(){
        System.out.println("Comentário");
    }
}
