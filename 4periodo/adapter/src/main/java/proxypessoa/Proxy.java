/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxypessoa;

/**
 *
 * @author rubia
 */
//Objeto intermediário que dará acesso ao Objeto Real
public class Proxy implements Subject {
    private String id;
    private Subject pessoa; //mesma interface
    
    public Proxy(String id) {
        this.id = id;
    }
    
    //Método comum da interface
    @Override
    public String getNome() {
        if (pessoa == null) {
            //Apenas cria o objeto real quando chamar este método
            pessoa = PessoaDAO.getPessoaByID(id);
        }
        //Delega para o objeto real
        return pessoa.getNome();
    }
    
    @Override
    public String getId() {
        return id;
    }
}
