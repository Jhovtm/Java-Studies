package br.com.cefet.projeto.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.cefet.projeto.modelo.ConnectionFactory;
import br.com.cefet.projeto.modelo.Produto;

public class TestaObterEAlterar {
    public static void main(String[] args) {
        int idParaBuscar = 2;
        String consulta = "SELECT id, descricao, preco_de_custo, data_cadastro FROM produto WHERE id = ?";

        try (Connection conexao = new ConnectionFactory().getConexao();
             PreparedStatement stmt = conexao.prepareStatement(consulta)) {
            stmt.setInt(1, idParaBuscar);

            try (ResultSet resultado = stmt.executeQuery()) {
                if (!resultado.next()) {
                    System.out.println("Produto com id " + idParaBuscar + " não encontrado.");
                    return;
                }

                Produto produto = new Produto(resultado.getInt("id"),
                        resultado.getString("descricao"), resultado.getDouble("preco_de_custo"),
                        resultado.getObject("data_cadastro", LocalDate.class));
                produto.mostrarDados();

                String atualizacao = "UPDATE produto SET descricao = ?, data_cadastro = ? WHERE id = ?";
                try (PreparedStatement atualizar = conexao.prepareStatement(atualizacao)) {
                    atualizar.setString(1, produto.getDescricao() + " (atualizado)");
                    atualizar.setObject(2, LocalDate.now());
                    atualizar.setInt(3, produto.getId());
                    System.out.println("Linhas afetadas: " + atualizar.executeUpdate());
                }
            }
        } catch (SQLException | IllegalStateException e) {
            System.err.println("Não foi possível obter ou alterar o produto: " + e.getMessage());
        }
    }
}
