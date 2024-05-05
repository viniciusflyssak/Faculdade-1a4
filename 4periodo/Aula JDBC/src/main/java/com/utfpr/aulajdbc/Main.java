/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulajdbc;

package aulajdbc;

import java.sql.*;
import java.util.Scanner;

public class Main{
    public static Statement st;
    
    public static void criaTabela(String query){
        try{
            st.executeUpdate(query); //Executar a query
        }catch(SQLException e){
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    };
    
    public static void criarTabelas(){   
        String query = "";
        query = " create table profissoes(id_profissao serial primary key, "
                + " nome varchar(255) constraint nnnome not null, "
                + " salario_base decimal (10,2)) ";
        criaTabela(query); //Executar a query
        
        query = " create table profissionais(id_profissional serial primary key, "
                + " nome varchar(255) constraint nnnome not null, "
                + " id_profissao integer constraint nnidprofissao not null, "
                + " cpf varchar(20) constraint nncpf not null, "
                + " sexo varchar(1) constraint nnsexo not null,"
                + " constraint profissionais_profissao foreign key (id_profissao) references profissoes(id_profissao)) ";
        criaTabela(query); //Executar a query
        
        query = " create table especies(id_especie serial primary key not null,"
                + " nome varchar(255) constraint nnnome not null,"
                + " nome_cientifico varchar(255),"
                + " longevidade integer); ";
        criaTabela(query);
        
        query = " create table animais (id_animal serial primary key,"
                + " nome varchar(255) constraint nnnome not null,"
                + " id_profissional integer constraint animais_profissionais references profissionais(id_profissional), "
                + " id_especie integer constraint animais_especies references especies(id_especie)) ";
        criaTabela(query); //Executar a query    

        query = " create table servicos(id_servico serial primary key, "
                + " nome varchar (100) constraint nnnome not null, "
                + " descricao varchar (255), "
                + " data_servico timestamp constraint nndata_servico not null, "
                + " id_profissional integer, "
                + " id_animal integer, "
                + " concluido bool,"
                + " constraint servicos_profissionais foreign key (id_profissional) references profissionais(id_profissional),"
                + " constraint servicos_animais foreign key (id_animal) references animais(id_animal));  ";
        criaTabela(query);
    };
    
    public static void main(String[] args)throws SQLException, ClassNotFoundException {
        //variáveis de conexão    
        String driverClassName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "9981";
        int opcao = 0;     
        Scanner scanner;
        
        //carregar o drive
        Class.forName(driverClassName);   

        //abrir conexao
        Connection conn = DriverManager.getConnection(url, user, password);

        //obter Statement
        st = conn.createStatement();

        //Cria tabelas
        criarTabelas();
        System.out.println("Tabelas criadas!");
                      
        //fechar conexao
        conn.close();
    }    
}