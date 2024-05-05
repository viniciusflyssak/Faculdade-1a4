/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compositeSupermercado;

/**
 *
 * @author vinic
 */
public class Produto extends ComponentesSetor{
    public String descricao;
    public double preco;
    String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public Produto(String descricao, double preco, String setor) {
        this.descricao = descricao;
        this.preco = preco;
        this.setor = setor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public void print(String ident){
        System.out.println(ident+getDescricao());
    }
}
