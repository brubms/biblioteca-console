package com.biblioteca;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.w3c.dom.ls.LSOutput;

public class TesteRelacionamentoJPA {

    public static void main(String[] args) {

        EntityManager em = FabricaEntityManager.getEntityManager();

        try{
            em.getTransaction().begin();

            String email = "bruno. " + System.currentTimeMillis() + "@gmail.com";
            Membro bruno = new Membro("Bruno Martins", email);
            em.persist(bruno);

            Livro cleanCode = new Livro("Clean Code " , "Robert Martin", 2008);
            Livro javaEfetivo = new Livro("Java Efetivo " , "Joshua Bloch", 2018);
            Livro entendendoAlgoritmos = new Livro("Entendendo Algoritmos", "Aditya Bhargava",2006 );

            em.persist(entendendoAlgoritmos);
            em.persist(cleanCode);
            em.persist(javaEfetivo);

            entendendoAlgoritmos.emprestarPara(bruno);
            cleanCode.emprestarPara(bruno);
            javaEfetivo.emprestarPara(bruno);

            em.getTransaction().commit();

            System.out.println("\n Dados persistidos e empréstimo realizado com sucesso no MySQL");

            System.out.println("\n Executando JPQL com JOIN...");
            String jpql = "SELECT livro FROM Livro livro JOIN livro.membro m WHERE m.email = :email";

            List<Livro> livrosDoBruno = em.createQuery(jpql, Livro.class)
                    .setParameter("email", email)
                    .getResultList();

            System.out.println("\n--- LIVROS EMPRESTADOS ENCONTRADOS ----");
            for(Livro livro : livrosDoBruno){
                System.out.println("titulo: " + livro.getTitulo() + "| Responsável: " + livro.getMembro().getNome());
            }
        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
            FabricaEntityManager.fechar();
        }
    }
}
