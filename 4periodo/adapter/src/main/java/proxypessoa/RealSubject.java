/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxypessoa;

/**
 *
 * @author rubia
 */
//Objeto Real
public class RealSubject implements Subject {
    private String nome;
    private String id;
    
    public RealSubject(String id, String nome) {
        this.id = id;
        this.nome = nome;
        //Apenas para simular algum retorno do banco
        System.out.println("Retornou a pessoa do banco de"
                + "dados -> "+nome);
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public String getId() {
        return id;
    }
}
