/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade3;

/**
 *
 * @author vinic
 */
public class Main {
    public static void main(String[] args) {
        Bloco blocoList = new Bloco();
        Questao[] questoes = blocoList.getQuestoes();
        
        Relatorio relatorio = new Relatorio();
        
        relatorio.imprimeBlocos(new Bloco().createIterator());
    }
}
