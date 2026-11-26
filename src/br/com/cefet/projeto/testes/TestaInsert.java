
package br.com.cefet.projeto.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.cefet.projeto.modelo.ConnectionFactory;
import br.com.cefet.projeto.modelo.Produto;

public class TestaInsert {

    public static void main(String[] args) {

        LocalDate dataCadastro = LocalDate.of(2025, 11, 5);

        Produto p = new Produto("Laranja duzia", 10, dataCadastro);

        Connection con = new ConnectionFactory().getConexao();

        String sql = "INSERT INTO produto(descricao, preco_de_custo, data_cadastro) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, p.getDescricao());
            stmt.setDouble(2, p.getPrecoDeCusto());
            stmt.setObject(3, p.getDataCadastro());

            stmt.execute();

            System.out.println("Produto " + p.getDescricao() + " inserido com sucesso.");

            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }
}
