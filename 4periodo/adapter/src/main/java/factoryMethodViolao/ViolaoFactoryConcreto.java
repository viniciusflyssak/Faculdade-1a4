/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodViolao;

/**
 *
 * @author vinic
 */
public class ViolaoFactoryConcreto extends ViolaoFactory{
    
    @Override
    public Violao createViolao(String marca){
        return switch(marca){
            case "EAGLE"-> new Eagle();
            case "GIANNINI"-> new Giannini();
            case "TAGIMA"-> new Tagima();
            default->null;
        };
    }
    
}
