package br.com.cefet.projeto.testes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.cefet.projeto.modelo.ConnectionFactory;
import br.com.cefet.projeto.modelo.Produto;

public class TestaInsert2 {
    public static void main(String[] args) {
    	LocalDate dataCadastro = LocalDate.of(2025, 11, 7); // 16: cria a data 07/11/2025 (ano, mês, dia)
    	Produto p = new Produto("Alfarroba", 9.50, dataCadastro); // 17: cria o objeto Produto com descrição, preço de custo e data. Ainda sem id.  	
    	Connection con = new ConnectionFactory().getConexao();  // 18: pede à fábrica uma conexão aberta com o banco
    	String sql = "INSERT INTO produto(descricao, preco_de_custo, data_cadastro) VALUES(?,?,?)"; // 19: SQL com 3 "?" (parâmetros). O id fica de fora porque é AUTO_INCREMENT
    	
    	try { // 20: bloco que pode lançar SQLException
    		PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// 22: prepara o SQL. RETURN_GENERATED_KEYS pede ao banco que devolva o id criado
    		stmt.setString(1, p.getDescricao());// 22/23: preenche o 1º "?" com a descrição (texto)
    		stmt.setDouble(2, p.getPrecoDeCusto()); // 23/24: preenche o 2º "?" com o preço (número decimal)
    		stmt.setObject(3, p.getDataCadastro()); // 24/25: preenche o 3º "?" com a data. setObject aceita LocalDate diretamente

    		stmt.execute(); // executeUpdate() retorna o rows affected
            // 25: executa o INSERT. O comentário lembra que executeUpdate() devolveria o número de linhas afetadas, mas aqui não usamos esse valor
    		ResultSet rs = stmt.getGeneratedKeys();  // 26: obtém um ResultSet com as chaves geradas (o novo id)
    		rs.next();  // 27: move o cursor para a primeira (e única) linha do resultado

    		p.setId(rs.getInt(1));  // 28: lê a 1ª coluna (o id gerado) e guarda no objeto Produto
    		System.out.println("Produto  "+p.getDescricao()+"  inserido com sucesso."); // 30: mensagem de sucesso mostrando descrição e id
    	}catch(SQLException e) { // 31: captura erros de banco (ex.: chave duplicada)
    		System.out.println("Erro ao inserir produto "+e.getMessage());   // 32: mostra a mensagem do erro
    	}
        
    	p.mostrarDados(); // 36: método da classe Produto que imprime os dados
    }
}
