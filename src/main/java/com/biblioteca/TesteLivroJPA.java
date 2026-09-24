package com.biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class TesteLivroJPA {

    public static void main(String[] args) {
    
    EntityManager em = FabricaEntityManager.getEntityManager();
    /* 
    em.getTransaction().begin();
    //crição dos lviros
    Livro livro1 = new Livro("Clean Code ", "Robert C.Martin", 2008);
    Livro  livro2 = new Livro("O Senhor dos Aneis ", "J.R.R. Tolkien", 1954);
    //para adicionar no banco de dados
    em.persist(livro2);
    em.persist(livro1);

    em.getTransaction().commit();

    System.out.println("Livro 1: " + livro1.getTitulo() + "salvo no ID: " + livro1.getId());
    System.out.println("Livro 2: " + livro2.getTitulo() + "salvo no ID: " + livro2.getId());


    em.close();
    FabricaEntityManager.fechar();
    */
        /* 
    em.getTransaction().begin();
    Livro livro = em.find(Livro.class, 4);
    livro.emprestar();
    em.getTransaction().commit();

    em.close();
    FabricaEntityManager.fechar();


        */

    em.getTransaction().begin();
    String jpql = "SELECT l FROM Livro l WHERE l.emprestado = false";
    List<Livro> livrosDisponiveis = em.createQuery(jpql,Livro.class).getResultList();

    for (Livro l : livrosDisponiveis) {
        System.out.println("disponiveis: " + l.getTitulo());    
        
    }


     }
}
