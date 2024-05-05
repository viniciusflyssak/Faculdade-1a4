/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulatcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vinic
 */
public class ServidorTCPExercicio {
    
    public static void main(String[] args) throws IOException
    {
        //Iniciar servidor, necessita de uma porta para ficar ouvindo as solicitaçòes
        ServerSocket servidor =  new ServerSocket(8081);
        
        Pessoa p = new Pessoa();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("servidorTCP");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        //consulta o banco
        em.createQuery(jpql, Pessoa.class).setParameter("nome", p.getNome()).getResultList();        
        em.close();
        
        System.out.println("Servidor na porta 8081");
        
        //Ficar no aguardo de alguma solicitação do lado dos clientes
        Socket socket = servidor.accept();
        
        //imprime o ip dos clientes ao conectar
        System.out.println("o cliente ip: " + socket.getInetAddress().getHostAddress() + " se conectou!");
        
        //Definir um stream de entrada de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                
        //Por padrão, o próprio Stream(socket) Java serializa as informações
        String mensagem = entrada.readUTF();
        
        //o servidor tem a função de converer string(char) para maiúsculo
        String novaMensagem = mensagem.toUpperCase();
        
        //Definir Stream de saída para os dados enviados para o cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        
        saida.writeUTF(novaMensagem);
        
        //fecho minhas strams de entrada e saída com os clientes
        entrada.close();
        saida.close();
        
        //Fecho a conexão
        socket.close();
        servidor.close();
    }
    
}
