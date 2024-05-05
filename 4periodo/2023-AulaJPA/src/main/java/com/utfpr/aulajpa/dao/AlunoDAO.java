package com.utfpr.aulajpa.dao;

import com.utfpr.aulajpa.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;

public class AlunoDAO {

    private EntityManager em;
    
    public AlunoDAO(EntityManager em){
        this.em = em;
    }
    
    public void salvar(Aluno aluno){
        this.em.persist(aluno);
    }
    
    public void excluir (Aluno aluno){
        this.em.merge(aluno);
        this.em.remove(aluno);
    }
    
    public Aluno buscaAluno(Long id){
        Aluno aluno = this.em.find(Aluno.class, id);
        return aluno;
    }
    
    public List<Aluno> buscaPorNome(String nome){
        String jpql = "SELECT * FROM alunos aluno where aluno.nome = :nome";
        return em.createQuery(jpql, Aluno.class).setParameter(1, nome).getResultList();
    }
}
