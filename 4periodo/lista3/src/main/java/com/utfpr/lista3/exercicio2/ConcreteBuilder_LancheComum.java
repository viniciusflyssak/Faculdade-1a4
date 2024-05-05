/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.lista3.exercicio2;

public class ConcreteBuilder_LancheComum extends Builder {

    @Override
    public void construirLanche(Lanche lanche) {
        resultado = new StringBuilder();
        resultado.append(lanche.getIngredientes());
        resultado = new StringBuilder();
        resultado.append(lanche.getIngredientes());
        resultado.append("\n");
        resultado.append("Versão: Comum");
        resultado.append("\n");
        resultado.append("Ingredientes:");
        resultado.append("\n");
        resultado.append("pão");
        resultado.append("\n");
        resultado.append("molho");
        resultado.append("\n");
        resultado.append("vegetais");
        resultado.append("\n");
        resultado.append("queijo");
        resultado.append("\n");
        resultado.append("Hambúrguer de gado");
        resultado.append("\n");
    }
}
