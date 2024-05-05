/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builderdocumento;

/**
 *
 * @author rubia
 */

//A classe Diretora
public class Main {
    protected static void construir(Builder constru, Documento doc) {
        constru.construirTitulo(doc);
        constru.construirAutor(doc);
        constru.construirConteudo(doc);
    }
    
    public static void main(String[] args) {
        //Intancia os dois tipos de builders
        Builder constDocComum = new ConcreteBuilder_DocComum();
        Builder constDocHtml = new ConcreteBuilder_DocHtml();
        //Inicializa o objeto complexo, passando suas partes
        //(ou passos) como parâmetro
        Documento doc = new Documento("Padrão GoF Builder", 
                "PP24S", "Conteúdo qualquer do documento");
        //constrói o documento sem formatação alguma
        construir(constDocComum, doc);
        //constrói o documento com formatação Html
        construir(constDocHtml, doc);
        //Exibe os resultados obtidos com as duas formatações
        System.out.println(constDocComum.obterResultado());
        System.out.println(constDocHtml.obterResultado());
    }
}
