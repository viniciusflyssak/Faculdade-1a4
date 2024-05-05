/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utfpr.aulajpa.dao;

import com.utfpr.aulajpa.model.Disciplina;
import javax.persistence.EntityManager;

/**
 *
 * @author vinic
 */
public class DisciplinaDAO {
    private EntityManager em;
    
    public DisciplinaDAO(EntityManager em){
        this.em = em;
    }
    
    public void salvar(Disciplina disciplina){
        this.em.persist(disciplina);
    }
    
    public void excluir (Disciplina disciplina){
        this.em.merge(disciplina);
        this.em.remove(disciplina);
    }   
    
    public Disciplina buscaDisciplina(Long id){
        Disciplina disciplina = this.em.find(Disciplina.class, id);
        return disciplina;
    }
}
