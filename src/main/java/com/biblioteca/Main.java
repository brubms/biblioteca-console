package com.biblioteca;

import com.biblioteca.Livro;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("========================");
        System.out.println(" BIBLIOTECA JAVA 1.0 ");
        System.out.println("========================");
       
        Biblioteca biblioteca = new Biblioteca("A Única");
        Membro membro1 = new Membro("Bruno Martins", "brunoberna21@gmail.com", 160122);
        Membro mebro2 = new Membro("Laiana Bernardo", "lalaimartins@outlook.com", 160123);
        Livro livro1 =  new Livro("Biblía", "Deus", 0);
        Livro livro2 = new Livro("Manual de Redação", "Desconhecido", 1900 );



        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarMembro(membro1);
        biblioteca.listarLivros();

        biblioteca.adicionarLivro(livro2);
        biblioteca.listarLivros();
        biblioteca.adicionarMembro(mebro2);

        biblioteca.listarMembros();

        biblioteca.buscarLivrosPorTitulo("Biblía");

        biblioteca.buscarMembrosPorId(160124);

        biblioteca.emprestarLivro("Manual da Redação", 160122);


        
        






        
        


    }
}