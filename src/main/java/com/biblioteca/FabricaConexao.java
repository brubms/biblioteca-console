package com.biblioteca;

/*Intenção: Trazer para o nosso arquivo a interface que representa uma conexão aberta 
com o banco. 
Motivo: O Java não carrega tudo na memória por padrão. 
Sempre que você for mexer com banco de dados, você precisa importar do pacote java.sql. 
Pense nela como a "linha telefônica" aberta com o MySQL.*/
import java.sql.Connection;
//-------------------------------------------------------------------------------
/*Intenção: Trazer a classe que atua como a "telefonista".
Motivo: O DriverManager gerencia os drivers instalados. 
Quando você disser "quero conectar no MySQL", é ele     
quem acha o driver que baixamos no pom.xml e faz a ligação. */
import java.sql.DriverManager;
//------------------------------------------------------------------------------
/*Intenção: Trazer a classe de exceção que avisa se a conexão falhar.
Motivo: Como visto no Módulo 2, conectar na rede é uma operação arriscada 
(o banco pode estar desligado, a porta errada, a senha inválida). 
O Java nos obriga a importar o SQLException para lidar com esses imprevistos. */
import java.sql.SQLException;

public class FabricaConexao {
    //Encapsulamento private, torna interno, já o static, faz pertencer somente a classe.
    //final, pois não poderá ser auterado o endereço do banco de dados.
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
    /* jdbc: -> se refere ao protocolo que o java usa para se comunicar com o banco de dados
        mysql1: -> o tipo de banco que vai ser utilizado
            localhost: -> o servidor que o banco está instalado
                3306 -> a porta de entrada do MySQL
                    biblioteca_db -> o banco de dados criado 
     */

                    // usuário e senha do banco
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    // método que abre e devolve uma conexão pronta para ser usada
    /*Sobre o throws SQLException, ele vai obrigar ser lançada uma exceção quando o método for 
    usado gerando ao sistema que caso aconteça algo com o sistema tenha uma mensagem. */
    public static Connection getConexao() throws SQLException{
        //devolve uma conexão entre o banco e o java
        return  DriverManager.getConnection(URL,USUARIO,SENHA);
    }
}
