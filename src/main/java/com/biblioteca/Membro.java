package com.biblioteca;

public class Membro {

    //Atributos:
    private String nome;
    private String email;
    private int id;
    private int livrosEmprestados = 0;
    private boolean ativo = true;
    private static int contador = 0;

    //Construtor:
    public Membro(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.id = ++contador;
    }
       

    //Método para pegar livros!
    public void pegarLivro(){

       if(livrosEmprestados>=3){
            System.out.println("Limite máximo atingido");
            return;
        }else{
            livrosEmprestados++;
        System.out.println(getNome() + " Pegou livro");

        }
        
        
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
            System.out.println(getNome() + " Desativado");
        }else{
            System.out.println("Não consigo desativar, Erro!!");
        }
    }
    public void reativar(){
            ativo = true;
            System.out.println(getNome() +" Ativo");

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
        return  getNome() + "|" + getEmail() + "|"  + getLivrosEmprestados() + "|" + (isAtivo() ? "sim" : "nao");
    }
}


