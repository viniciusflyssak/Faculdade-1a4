/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.padroesgof.builderdocumento;

/**
 *
 * @author rubia
 */
//Esta é a classe construtora que possui os métodos de 
//construção do objeto complexo (Documento)
public abstract class Builder {
    protected StringBuilder resultado;
    
    public abstract void construirTitulo(Documento doc);
    public abstract void construirAutor(Documento doc);
    public abstract void construirConteudo(Documento doc);

    //Método que exibe o resultado da construção, não
    //necessitando especialização
    public String obterResultado() {
        return resultado.toString();
    }
}
