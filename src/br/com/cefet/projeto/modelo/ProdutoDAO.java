package br.com.cefet.projeto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	private Connection conexao = null;
	
	public ProdutoDAO(Connection conexao){ // construtor
		this.conexao = conexao;
		}
	public void inserir(Produto o) throws DominioException{ //metodo
		String sql = "INSERT INTO produto(descricao, preco_de_custo, data_cadastro) VALUES(?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, o.getDescricao());
			stmt.setDouble(2, o.getPrecoDeCusto());
			stmt.setObject(3, o.getDataCadastro());
			stmt.executeUpdate();
			System.out.println("Produto "+o.getDescricao()+" inserido com sucesso");
		}catch(SQLException e) {
			throw new DominioException("Erro ao inserir produto"+e.getMessage());
		}
	}
	
	public void alterar(Produto c) throws DominioException{
		String sql = "UPDATE produto SET descricao = ?, data_cadastro = ?,preco_de_custo = ? WHERE id = ? ";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, c.getDescricao());
			stmt.setObject(2, c.getDataCadastro());
			stmt.setDouble(3, c.getPrecoDeCusto());
			stmt.setInt(4, c.getId());
			stmt.executeUpdate();
			System.out.println("Produto Alterado com sucesso");
		}catch(SQLException e) {
			throw new DominioException("Erro ao alterar produto "+e.getMessage());
		}
	}
	  public List<Produto> lista() throws DominioException {
	        List<Produto> produtos = new ArrayList<>();
	        String sql = "SELECT * FROM produto ORDER BY descricao";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Produto p = new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("preco_de_custo"));
	                p.setDataCadastro(rs.getObject("data_cadastro", LocalDate.class));
	                produtos.add(p);
	            }
	        } catch (SQLException e) {
	            throw new DominioException("Erro ao listar. " + e.getMessage());
	        }
	        return produtos;
	    }
	  
	  public Produto obterPeloId(int id) throws DominioException{
		  Produto produto = null;
		  String sql = "SELECT * FROM produto WHERE id = ?";
		  try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			  stmt.setInt(1, id);
			  try (ResultSet rs = stmt.executeQuery()) {
				  if (rs.next()) {
					  produto = new Produto(rs.getInt("id"), rs.getString("descricao"),
							  rs.getDouble("preco_de_custo"), rs.getObject("data_cadastro", LocalDate.class));
				  }
			  }
		  } catch (SQLException e) {
			  throw new DominioException("Erro ao obter produto: " + e.getMessage());
		  }
		  return produto;
	  }
	  
	  public int removerPeloId(int id) throws DominioException{
		  int linhasAfetadas=0;
		  String sql = "DELETE FROM produto WHERE id = ?";
		  try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			  stmt.setInt(1, id);
			  linhasAfetadas = stmt.executeUpdate();
			  System.out.println("Produto removido. Linhas afetadas: " + linhasAfetadas);
		  } catch(SQLException e) {
			  throw new DominioException("ERRO ao remover produto: "+e.getMessage());
		  }
		  return linhasAfetadas;
	  }
	  
	  
	}
