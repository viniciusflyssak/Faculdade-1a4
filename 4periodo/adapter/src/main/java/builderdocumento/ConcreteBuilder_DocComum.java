/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builderdocumento;

/**
 *
 * @author rubia
 */
//Implementação dos passos para construção do objeto
//complexo (Documento) considerando um documento comum
public class ConcreteBuilder_DocComum extends Builder {
    
    @Override
    public void construirTitulo(Documento doc) {
        resultado = new StringBuilder();
        resultado.append(doc.getTitulo());
        resultado.append("\n");
    }
    
    @Override
    public void construirAutor(Documento doc) {
        resultado.append(doc.getAutor());
        resultado.append("\n");
    }
    
    @Override
    public void construirConteudo(Documento doc) {
        resultado.append(doc.getConteudo());
        resultado.append("\n");
    }
}
