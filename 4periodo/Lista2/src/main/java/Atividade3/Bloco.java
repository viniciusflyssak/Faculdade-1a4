/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade3;

/**
 *
 * @author vinic
 */
public class Bloco {

    static final int MAX_QUESTOES = 7;
    int index = 0;
    Questao[] elementos;

    public Bloco() {
        elementos = new Questao[MAX_QUESTOES];
        adicionar(new Questao("Q1", "Bloco X"));
        adicionar(new Questao("Q2", "Bloco X"));
        adicionar(new Questao("Q3", "Bloco X"));
        adicionar(new Questao("Q4", "Bloco Y1"));
        adicionar(new Questao("Q5", "Bloco Y2"));
        adicionar(new Questao("Q6", "Bloco Y2"));
        adicionar(new Questao("Q7", "Bloco Y"));
    }

    public void adicionar(Questao elementoDoQuestionario) {
        if (index < MAX_QUESTOES) {
            elementos[index] = elementoDoQuestionario;
            index++;
        }
    }

    public void remover(Questao elementoDoQuestionario) {
        for (int i = 0; i < elementos.length; i++) {
            if ((elementos[i].getDescricao() == elementoDoQuestionario.getDescricao()) && (elementos[i].getBloco()== elementoDoQuestionario.getBloco())) {
                elementos[i].remover(elementoDoQuestionario);

            }
        }
    }

    public Questao[] getQuestoes() {
        return elementos;
    }

    public Iterator createIterator() {
        return new QuestionarioIterator(elementos);
    }
}
