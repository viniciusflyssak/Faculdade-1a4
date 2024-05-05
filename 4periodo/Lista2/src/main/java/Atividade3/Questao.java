/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade3;

/**
 *
 * @author vinic
 */
public class Questao extends ComponentesBloco{
    public String descricao;
    String bloco;


    public Questao(String descricao, double preco) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Questao(String descricao, String bloco) {
        this.descricao = descricao;
        this.bloco = bloco;
    }


    @Override
    public void exibir(String ident){
        System.out.println(ident+getDescricao());
    }
}
