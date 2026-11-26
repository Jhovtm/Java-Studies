package br.com.cefet.projeto.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cefet.projeto.modelo.ConnectionFactory;

public class TestaRemover {
    public static void main(String[] args) {
    	int idParaRemover = 4;
    	Connection con = new ConnectionFactory().getConexao();
    	
    	String sql = "DELETE FROM produto WHERE id = ?";
    	
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setInt(1, idParaRemover);
    		System.out.println("Produto removido com sucesso. Linhas afetadas "+stmt.executeUpdate());
    	}catch(SQLException e) {
    		System.out.println("ERRO ao remover produto "+e.getMessage());
    	}
    	
    }
}
