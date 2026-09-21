package com.biblioteca;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        try(Connection conexao = FabricaConexao.getConexao()){
            System.out.println("Conexão com MySQL realizada com sucesso!");
        }catch(SQLException e){
            System.err.println("Falha na conexão" + e.getMessage());
        }

    }

}
