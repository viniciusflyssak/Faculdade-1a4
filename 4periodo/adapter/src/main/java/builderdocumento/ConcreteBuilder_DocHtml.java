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
//complexo (Documento) considerando um documento HTML
public class ConcreteBuilder_DocHtml extends Builder {
    
    @Override
    public void construirTitulo(Documento doc) {
        resultado = new StringBuilder();
        resultado.append("<html><head><title>");
        resultado.append(doc.getTitulo());
        resultado.append("</title>"
                + "<meta charset='UTF-8'>"
                + "<meta charset='viewport' "
                + "content='with=device-with,initial-scale=1.0'>"
                + "</head><body><div align='center'><p>"
                + "<font size ='S'><strong>");
        resultado.append(doc.getTitulo());
        resultado.append("</strong></font><br>");        
    }
    
    @Override
    public void construirAutor(Documento doc) {
        resultado.append("<strong>Autor: ");
        resultado.append(doc.getAutor());
        resultado.append("<br>");
    }
    
    @Override
    public void construirConteudo(Documento doc) {
        resultado.append(doc.getConteudo());
        resultado.append("</strong></p></div></body></html>");
    }
}
