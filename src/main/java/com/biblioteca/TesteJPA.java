package com.biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

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

        /* 
        *inicia a fabrica e gera a conexão 
        EntityManager em = FabricaEntityManager.getEntityManager();
        
        *inicia a transação
        em.getTransaction().begin();
        *procurou o membro atraves do ID
        Membro membro = em.find(Membro.class, 6);
        *regra de negocio, fez o membro pegar o livro 
        membro.pegarLivro();
        *Ele vai dizer ao sistema que deu tudo certo, 
        *pode proceder com as alterações.
        em.getTransaction().commit();

        System.out.println("Encontrei: " + membro.getNome());

        
        *fecha a transação
        em.close();
        *fecha a fabrica de conexão
        FabricaEntityManager.fechar();

        */
        /* 
        EntityManager em = FabricaEntityManager.getEntityManager();

        *comando sql para o jpql
        String jpql = "SELECT m FROM Membro m";

        List<Membro> lista = em.createQuery(jpql,Membro.class).getResultList();

        for (Membro membro : lista) {
            System.out.println(membro);
        }

        em.close();
         FabricaEntityManager.fechar();
       */

        EntityManager em = FabricaEntityManager.getEntityManager();

        String jpql = "SELECT m FROM Membro m WHERE m.email = :emailBuscado";
        //está dizendo ao sistema para criar uma consulta
        Membro membro = em.createQuery(jpql,Membro.class)
        //setando o parametro
        .setParameter("emailBuscado", "brunoberna22@gmail.com")
        //devolve apenas o que estamos procurando 
        .getSingleResult();

        System.out.println("membro localizado: " + membro.getNome());

        em.close();
        FabricaEntityManager.fechar();
    
    }
}
