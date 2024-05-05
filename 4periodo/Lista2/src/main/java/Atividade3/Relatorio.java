/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade3;

/**
 *
 * @author vinic
 */
public class Relatorio {

    public void imprimeBlocos(Iterator iterator) {
        ComponentesBloco blocoX = new ElementosQuestionario("BLOCO X");
        ComponentesBloco blocoY = new ElementosQuestionario("BLOCO Y");
        ComponentesBloco blocoY1 = new ElementosQuestionario("BLOCO Y1");
        ComponentesBloco blocoY2 = new ElementosQuestionario("BLOCO Y2");
        while (iterator.hasNext()) {
            Questao questao = (Questao) iterator.next();
            if ("Bloco X".equals(questao.getBloco())) {
                blocoX.adicionar(questao);
            } else if ("Bloco Y1".equals(questao.getBloco())) {
                blocoY1.adicionar(questao);
            } else if ("Bloco Y2".equals(questao.getBloco())) {
                blocoY2.adicionar(questao);
            } else if ("Bloco Y".equals(questao.getBloco())) {
                blocoY.adicionar(blocoY1);
                blocoY.adicionar(blocoY2);
                blocoY.adicionar(questao);
            }
        }
        blocoX.exibir("");
        blocoY.exibir("");
    }
}
