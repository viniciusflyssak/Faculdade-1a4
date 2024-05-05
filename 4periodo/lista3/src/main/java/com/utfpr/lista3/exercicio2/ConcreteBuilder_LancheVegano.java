/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio2;

public class ConcreteBuilder_LancheVegano extends Builder {
    @Override
    public void construirLanche(Lanche lanche) {
        resultado = new StringBuilder();
        resultado.append(lanche.getIngredientes());
        resultado.append("\n");
        resultado.append("Versão: Vegano");
        resultado.append("\n");
        resultado.append("Ingredientes:");
        resultado.append("\n");
        resultado.append("pão vegano");
        resultado.append("\n");
        resultado.append("molho");
        resultado.append("\n");
        resultado.append("vegetais");
    }
}
