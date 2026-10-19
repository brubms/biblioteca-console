package com.biblioteca;

import jakarta.persistence.EntityManager;

public class TesteRegraEmprestimo {

    public static void main(String[] args) {



        Membro bruno = new Membro("Bruno Martins", "brunoberna212@gmail.com");
        Membro marcia = new Membro("Marcia","alguem123@gmail.com");


        Livro porqueDormimos = new Livro("Porque dormimos","Desconhecido",2009);
        Livro dicionarioAurelio = new Livro("Dicionario Aurelio","desconhecido",1900);


        porqueDormimos.emprestarPara(bruno);
        System.out.println(porqueDormimos.isEmprestado());
        System.out.println(porqueDormimos.getMembro());
        System.out.println(bruno.getLivros().size());
        System.out.println(porqueDormimos.getVezesEmprestado());


        try{
            porqueDormimos.emprestarPara(marcia);

        }catch (IllegalStateException e){
            System.out.println("capturado " + e.getMessage());
        }
        try {
            dicionarioAurelio.emprestarPara(null);
        }catch (IllegalArgumentException e){
            System.out.println("check " + e.getMessage());
        }

        marcia.desativar();

        porqueDormimos.devolver();

        porqueDormimos.emprestarPara(marcia);
        System.out.println(porqueDormimos.isEmprestado());
        System.out.println(porqueDormimos.getMembro());
        System.out.println(marcia.getLivros().size());
        System.out.println(porqueDormimos.getVezesEmprestado());



    }
}
