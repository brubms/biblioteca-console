package com.biblioteca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "livros")
public class Livro {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "titulo", nullable = false)
    private String titulo;
    @Column (name = "autor", nullable = false)
    private String autor;
    @Column (name = "ano_publicacao", nullable = false)
    private int anoPublicacao;
    @Column (name = "emprestado")
    private boolean emprestado;
    @Column (name = "vezes_emprestado")
    private int vezesEmprestado;

    //construtor vazio para o jpa
    public Livro(){

    }

    public Livro(String titulo, String autor, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        if(anoPublicacao<1500||anoPublicacao>2026){
            throw new IllegalArgumentException("Erro, ano inválido");
        }
        this.anoPublicacao = anoPublicacao;
        this.emprestado = false;
        
    }

    public void emprestar(){
        if(emprestado == false){
            this.emprestado = true;
            System.out.println("Livro emprestado");
            ++vezesEmprestado;
        }else{
            System.out.println("Livro já emprestado");

        }
        

    }

    public void devolver(){
        this.emprestado = false;
        System.out.println("Livro devolvido");

    }

    public int getId(){
        return this.id;
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
    public int getVezesEmprestado(){
        return this.vezesEmprestado;
    }

    @Override
    public String toString(){
        return titulo + "|" + autor + "|" + anoPublicacao + "|" + (isEmprestado()? "Emprestado" : "Disponivel" + "|" + "Top: " + vezesEmprestado);
    }
    
}
