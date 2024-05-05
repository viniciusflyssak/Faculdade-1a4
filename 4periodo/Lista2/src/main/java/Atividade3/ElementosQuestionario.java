/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade3;

import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class ElementosQuestionario extends ComponentesBloco{
    ArrayList<ComponentesBloco> componentes = new ArrayList<ComponentesBloco>();
    String descricao;

    public ArrayList<ComponentesBloco> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<ComponentesBloco> componentes) {
        this.componentes = componentes;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ElementosQuestionario(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public void adicionar(ComponentesBloco componente){
        componentes.add(componente);
    }
    
    @Override
    public void remover(ComponentesBloco componente){
        componentes.remove(componente);
    }
    
    @Override
    public ComponentesBloco getChild(int i){
        return (ComponentesBloco) componentes.get(i);
    }
    
    @Override
    public void exibir(String ident){
        System.out.println(ident+getDescricao());
        ident+="-";
        for(ComponentesBloco c: componentes){
            c.exibir(ident);
        }
    }

}
