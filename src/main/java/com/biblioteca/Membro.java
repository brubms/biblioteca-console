package com.biblioteca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
// essa anotação diz qual vai ser o nome da tabela!
@Table(name = "membros")
public class Membro {

    // Atributos:
    /*
    *nullable = false -> quer referênciar que aquele atributo
    *não pode faltar!
    */
    @Column(name = "nome", nullable = false)
    private String nome;
    /*
     * nesse caso o unique = true -> quer dizer que não podemos
     * ter dois emails cadastrados no banco de dados que sejam iguais,
     * torna se então único para o banco de dados
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "livros_emprestados", nullable = false)
    private int livrosEmprestados = 0;

    @Column(name = "ativo")
    private boolean ativo = true;

    public Membro() {

    }

    // Construtor:
    public Membro(String nome, String email) {
        this.nome = nome;
        this.email = email;

    }

    // Método para pegar livros!
    public void pegarLivro() {

        if (livrosEmprestados >= 3) {
            System.out.println("Limite máximo atingido");
            return;
        } else {
            livrosEmprestados++;
            System.out.println(getNome() + " Pegou livro");

        }

    }

    // método para devolução
    public void devolverLivro() {
        if (livrosEmprestados >= 1) {
            livrosEmprestados--;
            System.out.println(getNome() + " devolveu o livro!");

        } else {
            System.out.println("Não existem livros para devolver!");
        }
    }

    public void desativar() {
        if (livrosEmprestados == 0) {
            ativo = false;
            System.out.println(getNome() + " Desativado");
        } else {
            System.out.println("Não consigo desativar, Erro!!");
        }
    }

    public void reativar() {
        ativo = true;
        System.out.println(getNome() + " Ativo");

    }

    public String getNome() {
        return this.nome;

    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.id;
    }

    public int getLivrosEmprestados() {
        return this.livrosEmprestados;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    @Override
    public String toString() {
        return getNome() + "|" + getEmail() + "|" + getLivrosEmprestados() + "|" + (isAtivo() ? "sim" : "nao");
    }
}
