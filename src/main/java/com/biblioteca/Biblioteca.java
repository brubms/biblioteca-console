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
        for (Livro livro : livros) {
            System.out.println(livro);
            
        }
    }
    public void listarMembros(){
        for (Membro membro : membros) {
            System.out.println(membro);
        }
    }
    public Livro buscarLivrosPorTitulo(String titulo){
        for (Livro livro : livros) {
            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                return livro;
            }
        }
        return null;
    }
    public Membro buscarMembrosPorId(int id){
        for (Membro membro : membros) {
            if(id == membro.getId()){
                return membro;
            }
        }
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

}
