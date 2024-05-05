/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.adaptersobremesas;

/**
 *
 * @author vinic
 */
public class SobremesaAdapter{
    Sobremesa sobremesa = new Sobremesa();
    
    public double getPreco() {
        return sobremesa.getValor();
    }
    
    public SobremesaAdapter(Sobremesa sobremesa){
        this.sobremesa = sobremesa;
    }
    
}
