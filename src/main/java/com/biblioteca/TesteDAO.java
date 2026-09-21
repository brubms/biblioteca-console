package com.biblioteca;

import java.util.List;

public class TesteDAO {

    public static void main(String[] args) {

        MembroDAO membroDAO = new MembroDAOImpl();

        System.out.println("=== 1. TESTE: LISTAR TODOS DO BANCO ===");

        List<Membro> lista = membroDAO.listarTodos();

        for (Membro m : lista) {
            System.out.println("Encontrado: " + m.getNome() +
                    " | Email: " + m.getEmail());
        }

        System.out.println("\n=== 2. TESTE: BUSCAR POR ID ===");
        Membro bruno = membroDAO.buscarPorId(1);
        if(bruno != null){
            System.out.println("Recuperado do banco ID 1: " + bruno.getNome());
        }

        System.out.println("\n=== 3. TESTE: SALVAR NOVO MEMBRO ===");

        Membro novMembro = new Membro("Marina Silva", "marina@gmail.com");

        membroDAO.salvar(novMembro);
    }

}
