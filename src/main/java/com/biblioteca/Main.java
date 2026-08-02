package com.biblioteca;

import com.biblioteca.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //objeto scanner, faz a entrada do código, no caso para que o menu possa funcionar.
        Scanner scan = new Scanner(System.in);
        //Criação de uma nova biblioteca, está sendo instanciada uma biblioteca do tipo Biblioteca.
        Biblioteca biblioteca = new Biblioteca("Teste");
        //atributos para o menu, um para selecionar qual será a opção desejada e outro para encerrar as opções e voltar para o menu central
        String encerrar;
        int menu;   
        int id;
       
        
        //loop do menu
        do{
        // LIMPAR TERMINAL AQUI 
    System.out.print("\033[H\033[2J");
    System.out.flush();
        System.out.println("========================");
        System.out.println(" BIBLIOTECA JAVA 1.0 ");
        System.out.println("========================");
        System.out.println("==========MENU==========");
        System.out.println("1. Adicionar livro ");
        System.out.println("2. Adicionar membro ");
        System.out.println("3. Listar livros ");
        System.out.println("4. Listar membros ");
        System.out.println("5. Buscar livro por título ");
        System.out.println("6. Buscar membro por ID ");
        System.out.println("7. Emprestar livro ");
        System.out.println("8. Devolver livro ");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção:");
        //metodo usado para mudar um inteiro em String e não apagar informações.
        String menuStr = scan.nextLine();
        menu = Integer.parseInt(menuStr);
        //switch usado para selecionar qual opção do menu deve ser usada!
            switch (menu) {
                //1. --------------------------------Adicionar livro---------------------------------
                case 1:
                //Atributos:
                String titulo;
                String autor;
                //Loop
                do{
                    System.out.println("===SISTEMA DE CADASTRO===");
                    System.out.println("Para encerrar digite (N).");
                    System.out.println("Título: ");
                    titulo = scan.nextLine();
                    System.out.println("Autor:");
                    autor = scan.nextLine();
                    System.out.println("Ano: ");
                    String anoStr = scan.nextLine();
                    int ano = Integer.parseInt(anoStr);
                    
                    Livro criarLivro = new Livro(titulo, autor, ano);
                    biblioteca.adicionarLivro(criarLivro);
                    System.out.println("Deseja cadastar mais algum livro? (S/N)");
                    encerrar = scan.nextLine();  
                }while(!encerrar.equalsIgnoreCase("N"));
                    System.out.println("Encerrado...");
                break;
                //2. -----------------------------Adicionar membro-----------------------------
                case 2:
                //Atributos:
                String nome;
                String email;
                
                //Loop
                do{
                    System.out.println("===SISTEMA DE CADASTRO===");
                    System.out.println("Nome: ");
                    nome = scan.nextLine();
                    System.out.println("Email:");
                    email = scan.nextLine();
                    
                   
                    Membro membro = new Membro(nome, email);
                    biblioteca.adicionarMembro(membro);
                    System.out.println("Deseja cadastar mais algum membro? (S/N)");
                    encerrar = scan.nextLine();
                }while(!encerrar.equalsIgnoreCase("N"));
                    System.out.println("Encerrado...");
                break;
                //3. ----------------------Listar livros-------------------------
                case 3:
                    biblioteca.listarLivros();
                    System.out.println("\nPressione Enter para voltar ao menu...");
                    scan.nextLine();

                break;
                //4. --------------------------Listar membros-----------------------
                case 4:
            
                    biblioteca.listarMembros();
                     System.out.println("\nPressione Enter para voltar ao menu...");
                    scan.nextLine();
                break;
                //5. -----------------------------Buscar livro por título---------------------------------
                case 5:
                do{
                    System.out.println("Digite o titulo: ");
                    titulo = scan.nextLine();
                    Livro encontrado = biblioteca.buscarLivrosPorTitulo(titulo);
                    if(encontrado != null){
                        System.out.println("Livro encontrado: " + encontrado);
                    }else{
                        System.out.println(titulo + " não encontrado!");
                    }
                    System.out.println("Ainda quer procurar? (S/N)");
                    encerrar = scan.nextLine();
                    }while(!encerrar.equalsIgnoreCase("N"));
                    System.out.println("Encerrado...");
                break;
                //6. --------------------------------Buscar membro por ID --------------------------------
                case 6:   
                do{
                    
                    System.out.println("Digite o ID do membro: ");
                    String idStr = scan.nextLine();
                    id = Integer.parseInt(idStr);
                    Membro encontrado = biblioteca.buscarMembrosPorId(id);
                    if(encontrado != null){
                        System.out.println("Membro com ID: " + encontrado + " encontrado!!");
                    }else{
                        System.out.println(id + " não localizado" );
                    }
                    
                    System.out.println("Ainda quer procurar? (S/N)");
                    encerrar = scan.nextLine();
                }while(!encerrar.equalsIgnoreCase("N"));
                System.out.println("Encerrado...");
                break;
                //7. -------------------------------------Emprestar livro -------------------------------
                case 7:
                    
                do{
                    
                    System.out.println("Digite o ID do cliente: ");
                    String idStr = scan.nextLine();
                    id = Integer.parseInt(idStr);
                    
        
                    System.out.println("Digite o título do livro: ");
                     titulo = scan.nextLine();
        
                    biblioteca.emprestarLivro(titulo, id);
                    
                    System.out.println("Ainda quer emprestar? (S/N)");
                    encerrar = scan.nextLine();
                }while(!encerrar.equalsIgnoreCase("N"));
                    System.out.println("Encerrado...");

                break;
                //8. ----------------------------------Devolver livro-------------------------------------------
                case 8:
                    do{
                    
                    System.out.println("Digite o ID do cliente: ");
                    String idStr = scan.nextLine();
                    id = Integer.parseInt(idStr);
                    
        
                    System.out.println("Digite o título do livro: ");
                     titulo = scan.nextLine();
        
                    biblioteca.devolverLivro(titulo, id);
                    
                    System.out.println("Ainda quer devolver? (S/N)");
                    encerrar = scan.nextLine();
                }while(!encerrar.equalsIgnoreCase("N"));
                    System.out.println("Encerrado...");
                    

                break;
                // -----------------------------------SAIR----------------------------------------------
                case 0:
                    break;
            
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }

        }while(menu != 0);
        System.out.println("Você saiu...");
    }
}