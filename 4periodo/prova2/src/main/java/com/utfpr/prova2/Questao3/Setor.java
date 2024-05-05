/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.prova2.Questao3;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class Setor extends ComponentesSetor{
    ArrayList<ComponentesSetor> componentes = new ArrayList<ComponentesSetor>();
    String descricao;

    public ArrayList<ComponentesSetor> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<ComponentesSetor> componentes) {
        this.componentes = componentes;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public void add(ComponentesSetor componente){
        componentes.add(componente);
    }
    
    @Override
    public void remove(ComponentesSetor componente){
        componentes.remove(componente);
    }
    
    @Override
    public ComponentesSetor getChild(int i){
        return (ComponentesSetor) componentes.get(i);
    }
    
    @Override
    public void print(String ident){
        System.out.println(ident+getDescricao());
        ident+="-";
        for(ComponentesSetor c: componentes){
            c.print(ident);
        }
    }

}
