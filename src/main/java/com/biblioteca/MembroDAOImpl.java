package com.biblioteca;

import java.sql.Connection;
/*manda os comandos para o banco de forma segura */
import java.sql.PreparedStatement;
/*Quando faz um SELECT, o banco devolve uma tabela de respostas. 
O ResultSet é o "cursor" que lê linha por linha dessa tabela 
para você transformar em Java. */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//implementação da interface MembroDAO(implementação do contrato dentro da classe MembroDAOImpl)
public class MembroDAOImpl implements MembroDAO {

    @Override
    public void salvar(Membro membro) {
        // as ? são para armazenar os dados que serão recebidos
        String sql = "INSERT INTO membros (nome, email, ativo) VALUES (?, ?, ?)";
        // gerenciamento duplo
        try (Connection conexao = FabricaConexao.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            // colocar os dados em cada ponto de interrogação
            ps.setString(1, membro.getNome());
            ps.setString(2, membro.getEmail());
            ps.setBoolean(3, membro.isAtivo());
            // usado ao invez de ps.executeQuerry(), pois vai ser usado o INSERT, UPDATE E
            // DELETE
            ps.executeUpdate();
            System.out.println("Membro salvo com sucesso no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar" + e.getMessage());
        }
    }

    @Override
    public Membro buscarPorId(int id) {
        String sql = "SELECT id, nome, email, ativo FROM membros WHERE id = ?";

        try (Connection conexao = FabricaConexao.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, id);
            /*
             * ps.executeQuery() -> fazer leitura no banco, ele faz
             * consultas no banco
             * o ResultSet serve com um cursor, ao usar o .next() ele move o cursor
             */
            try (ResultSet rs = ps.executeQuery()) {
                /*
                 * Se existir uma linha com aquele ID, o rs.next()
                 * devolve true e entra no if.
                 * Se ninguém tiver esse ID no banco,
                 * ele devolve false e o método devolve null
                 */
                if (rs.next()) {
                    // aqui eles recebem os dados do banco de dados e converte para String
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    boolean ativo = rs.getBoolean("ativo");
                    /*
                     * Aqui acontece o momento inverso!
                     * Os dados saem do MySQL e voltam a nascer como
                     * um objeto Java na memória RAM!
                     */
                    Membro membro = new Membro(nome, email);
                    if (!ativo) {
                        membro.desativar();
                    }
                    return membro;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar membro por ID: " + e.getMessage());
        }

        return null;

    }

    public List<Membro> listarTodos() {

        List<Membro> membros = new ArrayList<>();
        String sql = "SELECT id, nome, email, ativo FROM membros";

        try (Connection conexao = FabricaConexao.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            /* Percorre até que tenha dados */
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                boolean ativo = rs.getBoolean("ativo");

                Membro membro = new Membro(nome, email);

                if (!ativo) {
                    membro.desativar();
                }
                membros.add(membro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar todos os membros: " + e.getMessage());
        }

        return membros;
    }

    @Override
    public void atualizar(Membro membro) {
        // SQL com WHERE id = ? para atualizar apenas o membro correto
        String sql = "UPDATE membros SET nome = ?, email = ?, ativo = ? WHERE id = ?";
        try (Connection conexao = FabricaConexao.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, membro.getNome());
            ps.setString(2, membro.getEmail());
            ps.setBoolean(3, membro.isAtivo());
            ps.setInt(4, membro.getId());
            ps.executeUpdate();
            System.out.println("Membro atualizado com sucesso no banco de dados!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar membro: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        // SQL com WHERE id = ? para apagar apenas o membro correto
        String sql = "DELETE FROM membros WHERE id = ?";
        try (Connection conexao = FabricaConexao.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Membro deletado com sucesso do banco de dados!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar membro: " + e.getMessage());
        }
    }

}
