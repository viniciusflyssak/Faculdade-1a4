/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxypessoa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rubia
 */
public class Main {
    public static void main(String[] args) {
        List<Subject> pessoas = new ArrayList<Subject>();
        //Cria cada proxy para encapsular o acesso a classe
        //PessoaDAO
        pessoas.add(new Proxy("AAA"));
        pessoas.add(new Proxy("BBB"));
        pessoas.add(new Proxy("CCC"));
        
        //busca do banco de dados
        System.out.println("Nome: "+pessoas.get(0).getNome());
        
        //busca do banco de dados
        System.out.println("Nome: "+pessoas.get(1).getNome());
        
        //Já buscou esta pessoa...retorna do cache
        System.out.println("Nome: "+pessoas.get(0).getNome());
        
        //A terceira pessoa nunca será consultada no banco de
        //dados (melhor performance - lazy loading)
        System.out.println("Id da 3a - "+pessoas.get(2).getId());
    }
}
