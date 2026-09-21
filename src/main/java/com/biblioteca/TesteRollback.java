package com.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteRollback {
    public static void main(String[] args){
        String sql = "INSERT INTO membros (nome, email, ativo) VALUES(?,?,?)";

        try(Connection conexao = FabricaConexao.getConexao()){

        conexao.setAutoCommit(false);

        try(PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1,"Membro Fanstasma");
            ps.setString(2,"fantasma@email.com");
            ps.setBoolean(3, true);

            ps.executeUpdate();

            System.out.println("1. Comando executado na transação (ainda na memória do banco)...");

            if(true){
                throw new RuntimeException("Simulação de queda de energia");
            }

            conexao.commit();
            System.out.println("1. Comando executado na transação (ainda na memória do banco)...");

        }catch(Exception e){
            System.err.println("Erro capturado: " + e.getMessage());
                conexao.rollback();
                System.out.println("🔄 ROLLBACK EXECUTADO! Todas as alterações foram desfeitas!");
        }
        }catch(SQLException e){
            System.err.println("Falha na conexão: " + e.getMessage());
        }
    }

}
