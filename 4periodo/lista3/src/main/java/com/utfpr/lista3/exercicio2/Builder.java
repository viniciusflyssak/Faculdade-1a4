/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio2;

public abstract class Builder {
    protected StringBuilder resultado;
    
    public abstract void construirLanche(Lanche lanche);

    public String obterResultado() {
        return resultado.toString();
    }
}
