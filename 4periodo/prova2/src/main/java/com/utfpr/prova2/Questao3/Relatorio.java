/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao3;

/**
 *
 * @author vinic
 */
public class Relatorio {
    
    public void imprimeSetores(Iterator iterator) {
        ComponentesSetor setores = new Setor("Treinos");
        ComponentesSetor perna = new Setor("PERNA");
        ComponentesSetor braco = new Setor("BRACO");
        ComponentesSetor corrida = new Setor("CORRIDA");
        while (iterator.hasNext()){ 
            Exercicio exercicio = (Exercicio) iterator.next();
            if ("Braco".equals(exercicio.getSetor())) {
                braco.add(exercicio);
            } else if ("Perna".equals(exercicio.getSetor())) {
                perna.add(exercicio);
            } else if ("Corrida".equals(exercicio.getSetor())) {
                corrida.add(exercicio);
            } else {
                setores.add(exercicio);
            }            
        }
        setores.add(braco);
        setores.add(perna);
        perna.add(corrida);
        setores.print("");
    }
}
