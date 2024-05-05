/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao2;

/**
 *
 * @author vinic
 */
public class Treino {

    static final int MAX_EXERCICIOS = 6;
    int index = 0;
    Exercicio[] exercicios;

    public Treino() {
        exercicios = new Exercicio[MAX_EXERCICIOS];
        addExercicio("Levantamento de alteres", "Braco");
        addExercicio("Caminhada", "Perna");
        addExercicio("Levantamento de pesos", "Braco");
        addExercicio("Dança", "Perna");
        addExercicio("Com obstáculos", "Corrida");
        addExercicio("Sem obstáculos", "Corrida");
    }

    public void addExercicio(String descricao, String setor) {
        Exercicio exercicio = new Exercicio(descricao, setor);
        if (index < MAX_EXERCICIOS) {
            exercicios[index] = exercicio;
            index++;
        }
    }

    public Exercicio[] getExercicios() {
        return exercicios;
    }

}
