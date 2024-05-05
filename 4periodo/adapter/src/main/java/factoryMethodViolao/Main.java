/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodViolao;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        ViolaoFactory fabrica = new ViolaoFactoryConcreto();
        System.out.println("Giannini");
        Violao g = fabrica.createViolao("GIANNINI");
        System.out.println(g.getPreco());
        
        System.out.println("Tagima");
        Violao t = fabrica.createViolao("TAGIMA");
        System.out.println(t.getPreco());
        
        System.out.println("Eagle");
        Violao e = fabrica.createViolao("EAGLE");
        System.out.println(e.getPreco());
        
        
    }
    
}
