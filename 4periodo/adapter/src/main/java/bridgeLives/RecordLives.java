/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class RecordLives extends Live {
    public RecordLives(IPlatform platform){
        super.platform = platform;
    }
    
    public void gravar(){
        System.out.println("Gravando live...");
    }
}
