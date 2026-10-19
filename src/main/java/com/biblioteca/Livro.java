package com.biblioteca;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "ano_publicacao", nullable = false)
    private int anoPublicacao;

    @Column(name = "emprestado")
    private boolean emprestado;

    @Column(name = "vezes_emprestado")
    private int vezesEmprestado;

    @ManyToOne // ---> diz ao JPA que muitos livros podem pertencer a único membro
    @JoinColumn(name = "membro_id") //---> cria fisicamente a coluina membro_id dentro da tabela livros
    private Membro membro;

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

    public void emprestarPara(Membro membro){
        if(this.emprestado == true){
            throw new IllegalStateException("Livro já foi emprestado");
        }
        if(membro == null){
            throw new IllegalArgumentException("Membro não pode ser nulo");
        }
        if (!membro.isAtivo()){
            throw new IllegalStateException("Membro inativo não pode realizar emprestimo.");
        }

            this.emprestado = true;
            this.membro = membro;
            this.vezesEmprestado++;
            membro.getLivros().add(this);

        

    }

    public void devolver(){
        if(this.emprestado){
            this.emprestado = false;
            this.membro = null;
            System.out.println("Livro: " + this.titulo + " devilvido com sucesso!");
        }else{
            System.out.println("Livro já está disponível na biblioteca.");
        }
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public Membro getMembro(){ return this.membro;}


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
