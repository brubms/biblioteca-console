 package com.biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FabricaEntityManager {

    private static final EntityManagerFactory emf = 
    Persistence.createEntityManagerFactory("biblioteca-pu");

    public static EntityManager getEntityManager(){

        return emf.createEntityManager();

    }

    public static void fechar(){
        emf.close();
    }



}
