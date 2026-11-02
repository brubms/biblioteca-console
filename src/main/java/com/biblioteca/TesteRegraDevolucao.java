package com.biblioteca;

public class TesteRegraDevolucao {
    public static void main(String[] args) {
        Membro bruno = new Membro("Bruno Martins","bruno123@gmail.com");
        Livro cleanCode = new Livro("Clean Code","Desconhecido",2007);

        cleanCode.emprestarPara(bruno);
        cleanCode.devolver();

        cleanCode.isEmprestado();
        cleanCode.getMembro();
        bruno.getLivros().size();

        System.out.println(cleanCode.isEmprestado());
        System.out.println(cleanCode.getMembro());
        System.out.println(bruno.getLivros().size());

        try{
            cleanCode.devolver();
        }catch (IllegalStateException e){
            System.out.println("sucesso" + e.getMessage());

        }
    }
}
