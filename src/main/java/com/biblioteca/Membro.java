package com.biblioteca;

public class Membro {

    //Atributos:
    private String nome;
    private String email;
    private int id;
    private int livrosEmprestados = 0;
    private boolean ativo = true;

    //Construtor:
    public Membro(String nome, String email, int id){
        this.nome = nome;
        this.email = email;
        this.id = id;
    }
       

    //Método para pegar livros!
    public void pegarLivro(){
        livrosEmprestados++;
        System.out.println(getNome() + " Pegou livro");
    }

    //método para devolução
    public void devolverLivro(){
        if(livrosEmprestados >=1){
            livrosEmprestados--;
            System.out.println(getNome()  +" devolveu o livro!");
         
        }else{
            System.out.println("Não existem livros para devolver!");
        }
    }

    public void desativar(){
        if(livrosEmprestados == 0){
            ativo = false;
            System.out.println("Desativado");
        }else{
            System.out.println("Não consigo desativar, Erro!!");
        }
    }
    public void reativar(){
            ativo = true;
            System.out.println("Ativo");

    }

    public String getNome(){
       return this.nome;
       
    }
    public String getEmail(){
       return this.email;
    }
    public int getId(){
        return this.id;
    }
    public int getLivrosEmprestados(){
        return this.livrosEmprestados;
    }

    public boolean isAtivo(){
        return this.ativo;
    }

    @Override
    public String toString(){
        return  getNome() + "|" + getEmail() + "|" + getId() + "|" + getLivrosEmprestados() + "|" + (isAtivo() ? "sim" : "nao");
    }
}


