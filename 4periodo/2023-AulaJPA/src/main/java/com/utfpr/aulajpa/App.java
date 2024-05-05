package com.utfpr.aulajpa;

import com.utfpr.aulajpa.dao.AlunoDAO;
import com.utfpr.aulajpa.dao.DisciplinaDAO;
import com.utfpr.aulajpa.model.Aluno;
import com.utfpr.aulajpa.model.Disciplina;
import com.utfpr.aulajpa.util.Factory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("aulaJPA");
        EntityManager em = Factory.getEntityManager();                
        
        Disciplina dis = new Disciplina("Matemática", 100);
        
        AlunoDAO alunoDAO = new AlunoDAO(em);
        DisciplinaDAO disDAO = new DisciplinaDAO(em);              
        
        em.getTransaction().begin();
        
        dis = disDAO.buscaDisciplina(4L);
        Aluno aluno = new Aluno("Pedro", 5555, 8.2, dis);
//        disDAO.salvar(dis);
        alunoDAO.salvar(aluno);
        
        System.out.println(dis.getNome());
        em.getTransaction().commit();
        em.close();
    }
}
