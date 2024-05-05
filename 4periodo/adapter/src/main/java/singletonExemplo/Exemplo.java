/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singletonExemplo;
/**
 *
 * @author vinic
 */
public class Exemplo {
    private static int numInstancias = 0;
    private int cont;
    private static Exemplo instancia;  
    private Exemplo(){
        cont = ++ numInstancias;
    }
    
}
