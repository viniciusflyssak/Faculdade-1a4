/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade3;

/**
 *
 * @author vinic
 */
public class QuestionarioIterator implements Iterator{
    private Questao[] questoes;
    private int index = 0;

    public QuestionarioIterator(Questao[] questoes) {
        this.questoes = questoes;
    }

    @Override
    public boolean hasNext() {
        return index < questoes.length && questoes[index] != null;
    }

    @Override
    public Object next() {
        return questoes[index++];
    }
    
    
}
