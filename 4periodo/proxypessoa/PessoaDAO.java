/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.padroesgof.proxypessoa;

/**
 *
 * @author rubia
 */
//Imaginem que essa classe faz acesso ao banco  de dados
public class PessoaDAO {
    public static Subject getPessoaByID(String id) {
        System.out.println("select * from PESSOA where id="+id);
        return new RealSubject(id, "Pessoa "+ id);
    }
}
