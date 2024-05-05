/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao3;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();        
        relatorio.imprimeSetores(new Treino().createIterator());
    }
}
