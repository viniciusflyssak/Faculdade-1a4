/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridgeLives;

/**
 *
 * @author vinic
 */
public class Live implements ITransmission{
    protected IPlatform platform;
    
    public Live(){
        
    }
    
    public Live(IPlatform platform){
        this.platform = platform;
    }
    
    public void broadcasting(){
        System.out.println("Iniciando a transmissao");
    }
    
    @Override
    public void result(){
        System.out.println("No ar");
    }
}
