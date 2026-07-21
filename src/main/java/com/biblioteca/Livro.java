package com.biblioteca;

public class Livro {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean emprestado;

    public Livro(String titulo, String autor, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = false;
    }

    public void emprestar(){
        if(emprestado == false){
            this.emprestado = true;
            System.out.println("Livro emprestado");
        }else{
            System.out.println("Livro já emprestado");

        }

    }

    public void devolver(){
        this.emprestado = false;
        System.out.println("Devolvido!");

    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public boolean isEmprestado(){
        return emprestado;
    
    }

    @Override
    public String toString(){
        return titulo + "|" + autor + "|" + anoPublicacao + "|" + (isEmprestado()? "Emprestado" : "Disponivel");
    }
    
}
