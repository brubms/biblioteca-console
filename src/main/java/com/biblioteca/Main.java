package com.biblioteca;

import com.biblioteca.Livro;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("========================");
        System.out.println(" BIBLIOTECA JAVA 1.0 ");
        System.out.println("========================");
       
        Livro livro1 = new Livro("Biblía", "Deus", 0);
        Membro membro1 = new Membro("Bruno Martins", "brunoberna21@gmail.com", 12458);
        Membro membro2 = new Membro("Laiana Martins", "laiana123@hotmail.com", 28516);

        
        System.out.println(membro1);
        System.out.println(membro2);

        membro1.pegarLivro();
        membro2.pegarLivro();

        System.out.println(membro1);
        System.out.println(membro2);
        
        membro1.pegarLivro();
        membro1.pegarLivro();
        membro1.pegarLivro();
        membro1.pegarLivro();

        System.out.println(membro1);
        System.out.println(membro2);

        membro1.devolverLivro();
        membro1.devolverLivro();
        membro1.devolverLivro();
        membro1.devolverLivro();

        System.out.println(membro1);
        System.out.println(membro2);

        membro1.devolverLivro();

        System.out.println(membro1);
        System.out.println(membro2);

        membro1.devolverLivro();

        System.out.println(membro1);
        System.out.println(membro2);

        membro2.desativar();

        System.out.println(membro1);
        System.out.println(membro2);

        membro2.devolverLivro();
        System.out.println(membro1);
        System.out.println(membro2);

        membro1.desativar();
        membro2.desativar();

        System.out.println(membro1);
        System.out.println(membro2);

        membro1.reativar();
        membro2.reativar();

        System.out.println(membro1);
        System.out.println(membro2);





    }
}