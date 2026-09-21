package com.biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
        EntityManager em = emf.createEntityManager();

        System.out.println("Hibernate conectou ao MySQL");

        em.close();
        emf.close();
    }
}
