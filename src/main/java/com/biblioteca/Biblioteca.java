package com.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private String nome;
    private ArrayList<Livro> livros;
    private ArrayList<Membro> membros;
   

    public Biblioteca(String nome){
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
        System.out.println(livro.getTitulo() + " adicionado!");
    }
    public void adicionarMembro(Membro membros){
        this.membros.add(membros);
        System.out.println("Seja bem-vindo " + membros.getNome());
    }
    public void listarLivros(){
        for (Livro livro : livros) {
            System.out.println(livro);
            
        }

    }
    public void listarMembros(){
        for (Membro membro : membros) {
            System.out.println(membro);
        }

    }
    public void buscarLivrosPorTitulo(String titulo){

        for (Livro livro : livros) {
            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                System.out.println(livro.getTitulo() + " encontrado");
                return;
            }

        }
        System.out.println("Livro não localizado!!!");
        
    }
    public void buscarMembrosPorId(int id){
        for (Membro membro : membros) {
            if(id == membro.getId()){
                System.out.println(membro.getId() + ", membro localizado!!");
                return;
            }

        }
        System.out.println(id + ", não localizado!!!");

    }
    public Livro emprestarLivro(String titulo, int idMembro){
        
        for (Livro livro : livros) {
            if(titulo.equalsIgnoreCase(livro.getTitulo())){
               return livro; 
            }
            for (Membro membro : membros) {
            if(idMembro == membro.getId()){
            
            }
            return null;
        }
        }
    
        Livro livro = emprestarLivro(titulo, idMembro);
        return emprestarLivro(titulo, idMembro);
       
        

        
        

    }
    public void devolverLivro(String titulo, int idMembro){

    }


}
