package br.com.cefet.projeto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDaoPersistivel implements Persistivel<Servico> {
    private final Connection conexao;

    public ServicoDaoPersistivel(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Servico servico) throws DominioException {
        String sql = "INSERT INTO servico(descricao, valor) VALUES(?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getValor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DominioException("Erro ao inserir serviço: " + e.getMessage());
        }
    }

    @Override
    public int alterar(Servico servico) throws DominioException {
        String sql = "UPDATE servico SET descricao = ?, valor = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getValor());
            stmt.setInt(3, servico.getId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DominioException("Erro ao alterar serviço: " + e.getMessage());
        }
    }

    @Override
    public List<Servico> listar() throws DominioException {
        String sql = "SELECT id, descricao, valor FROM servico ORDER BY descricao";
        List<Servico> servicos = new ArrayList<>();
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                servicos.add(new Servico(rs.getInt("id"), rs.getString("descricao"),
                        rs.getDouble("valor")));
            }
            return servicos;
        } catch (SQLException e) {
            throw new DominioException("Erro ao listar serviços: " + e.getMessage());
        }
    }

    @Override
    public Servico obterPeloId(int id) throws DominioException {
        String sql = "SELECT id, descricao, valor FROM servico WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Servico(rs.getInt("id"), rs.getString("descricao"),
                            rs.getDouble("valor"));
                }
                return null;
            }
        } catch (SQLException e) {
            throw new DominioException("Erro ao obter serviço: " + e.getMessage());
        }
    }

    @Override
    public int removerPeloId(int id) throws DominioException {
        String sql = "DELETE FROM servico WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DominioException("Erro ao remover serviço: " + e.getMessage());
        }
    }
}
