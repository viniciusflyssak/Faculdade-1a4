/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factoryMethodViolao;

/**
 *
 * @author vinic
 */
public abstract class ViolaoFactory {
    protected abstract Violao createViolao(String marca);
    
    public Violao calcularPreco(String tipo){
        Violao violao = createViolao(tipo);
        return violao;
    }
}
