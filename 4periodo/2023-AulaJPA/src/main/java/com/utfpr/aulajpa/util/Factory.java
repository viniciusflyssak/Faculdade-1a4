package com.utfpr.aulajpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
    private static final EntityManagerFactory FACTORY = 
            Persistence.createEntityManagerFactory("aulaJPA");
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
