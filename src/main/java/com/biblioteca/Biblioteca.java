package com.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    //Atributos
    private String nome;
    private ArrayList<Livro> livros;
    private ArrayList<Membro> membros;

   
    //Construtor
    public Biblioteca(String nome){
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    //Métodos
    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
        System.out.println(livro.getTitulo() + " adicionado!");
    }
    public void adicionarMembro(Membro membro){
        this.membros.add(membro);
        System.out.println("Seja bem-vindo " + membro.getNome());
    }
    public void listarLivros(){
       if(livros.isEmpty()){
        System.out.println("Nenhum livro cadastrado!");
         return;
       }
        for (Livro livro : livros) {
        System.out.println(livro); 
        }
            
        
    }
    public void listarMembros(){
        if(membros.isEmpty()){
            System.out.println("Nenhum membro foi cadastrado!");
            return;
        }
        for (Membro membro : membros) {
            System.out.println(membro);
        }
    }
    public Livro buscarLivrosPorTitulo(String titulo){

        if(livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado!");
            return null;
        }
        for (Livro livro : livros) {
            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                return livro;
            }
        }
        System.out.println("Livro " + livros + " não encontrado!");
        return null;
    }
    public Membro buscarMembrosPorId(int id){

        if(membros.isEmpty()){
            System.out.println("Nenhum membro cadastrado!");
            return null;
        }
        for (Membro membro : membros) {
            if(id == membro.getId()){
                return membro;
            }
        }
        System.out.println("Membro com ID: " + id + " não encontrado!");
        return null;
    }
    public void emprestarLivro(String titulo, int idMembro){
        
        Livro livro = buscarLivrosPorTitulo(titulo);
        Membro membro = buscarMembrosPorId(idMembro);

        if(livro == null){
            System.out.println("Erro, livro não encontrado");
            return;
        }
        if(membro == null){
            System.out.println("Erro, membro não existe");
            return;
        }
        if(livro.isEmprestado()){
            System.out.println("erro, livro não disponivel!!");
            return;
        }

        livro.emprestar();
        membro.pegarLivro();

    }

    public void devolverLivro(String titulo, int idMembro){

      Livro livro = buscarLivrosPorTitulo(titulo);
      Membro membro = buscarMembrosPorId(idMembro);

        if(livro == null){
            System.out.println("Erro, livro não encontrado");
            return;
        }

        if(membro == null){
            System.out.println("Erro, membro não existe");
            return;
        }
        if(!livro.isEmprestado()){
            System.out.println("Erro: livro não está emprestado, não pode devolver");
            return;
        }

        membro.devolverLivro();
        livro.devolver();


    }
    public int contarLivrosPorAutor(String autor){
        int contador = 0;
        for (Livro livro : livros) {
            if(livro.getAutor().equalsIgnoreCase(autor)){
                contador = contador + 1;
            }
            
        }
        
        return contador;
    }

}
