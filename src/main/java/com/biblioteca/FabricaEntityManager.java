package com.biblioteca;
//imports
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FabricaEntityManager {
    /*
    *método static para a variavel pertencer a classe, 
    *beneficio não precisa iniciar com new toda vez
    *uma unica vez é sufuciente.

    *método final -> se torna imutavel

    *Persistence.createEntityManagerFactory("biblioteca-pu"): 
    *Dispara a leitura do arquivo META-INF/persistence.xml, 
    *valida as entidades anotadas com @Entity, 
    *estabelece o pool de conexões com o MySQL e 
    *cria a infraestrutura pesada do Hibernate.
    
    */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca-pu");

    /*
    *A fábrica cria e devolve uma nova instância de EntityManager. 
    *Esse objeto é leve, possui seu próprio contexto de persistência 
    *em memória (First-Level Cache / Persistence Context) e 
    *não é thread-safe (pertence exclusivamente a quem o solicitou).
    
    */

    public static EntityManager getEntityManager() {

        return emf.createEntityManager();

    }
    /*
    *emf.close();: Fecha o pool de conexões do Hibernate e 
    *libera todos os recursos de rede e memória alocados pelo driver 
    *do MySQL ao encerrar a aplicação.
    */
    public static void fechar() {
        emf.close();
    }

}
