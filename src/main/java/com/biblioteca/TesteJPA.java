package com.biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteJPA {
    public static void main(String[] args) {

        
        /*
         * O EntityManagerFactory só existe um no programa que abre ao aplicação ser
         * criada e fecha quando sistema encerra!
         */
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");
        /*
        EntityManager é criado para cada úsuario, ao cada um solicitar algo 
        ele é criado
        */
        //EntityManager em = emf.createEntityManager();

        //System.out.println("Hibernate conectou ao MySQL");

        //em.close();
        //emf.close();

        EntityManager em = FabricaEntityManager.getEntityManager();
        
        

        em.getTransaction().begin();
        Membro membro = em.find(Membro.class, 6);
        membro.pegarLivro();
        em.getTransaction().commit();

        System.out.println("Encontrei: " + membro.getNome());

        

        em.close();
        FabricaEntityManager.fechar();
    
    }
}
