/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulaserializa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author vinic
 */
public class App {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        Empregado e  = new Empregado("Raul", "Caixa de água", 2, 123);
        //Gera arquivo
        FileOutputStream gerarArquivo = new FileOutputStream("d:/teste.txt");
        //Salva no caminho passado
        ObjectOutputStream saida = new ObjectOutputStream(gerarArquivo);
        saida.writeObject(e);
        
        saida.close();
        gerarArquivo.close();
        
        Empregado a = null;
        FileInputStream lerArquivo = new FileInputStream("d:/teste.txt");
        ObjectInputStream entrada = new ObjectInputStream(lerArquivo);
        
        a = (Empregado) entrada.readObject();
        
        System.out.println("Arquivo contém: ");
        System.out.println("Nome: " + a.nome);
        System.out.println("Rua: " + a.rua);
        System.out.println("Número da casa: " + a.num);
        System.out.println("Cpf: " + a.cpf);
    }
    
}
