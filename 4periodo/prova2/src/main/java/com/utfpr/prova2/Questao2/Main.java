/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao2;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        Treino treino = new Treino();
        Exercicio[] exercicios = treino.getExercicios();
        
        Relatorio relatorio = new Relatorio();        
        relatorio.imprimeSetores(exercicios);
    }
}
