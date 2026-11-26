package br.com.cefet.projeto.testes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.cefet.projeto.modelo.ConnectionFactory;
import br.com.cefet.projeto.modelo.Produto;
public class TestaListar {
    public static void main(String[] args) {
    	List<Produto> produtos = new ArrayList<>(); // Cria uma lista vazia que vai guardar os produtos lidos do banco
    	
    	Connection con = new ConnectionFactory().getConexao(); // Abre a conexão com o banco usando a classe do projeto

    	String sql = "SELECT * FROM produto ORDER BY descricao";// SQL que busca todas as colunas de todos os produtos, em ordem alfabética de descrição.
    	// Não há "?" porque não há parâmetros

    	try {
    	    PreparedStatement stmt = con.prepareStatement(sql); // Prepara o comando SQL

    	    ResultSet rs = stmt.executeQuery();// Executa o SELECT. executeQuery() é usado para consultas e devolve um ResultSet
    	    // (a "tabela" de resultado, com o cursor posicionado ANTES da primeira linha)

    	    while (rs.next()) {  // next() avança o cursor para a próxima linha e devolve true se ela existe.// O laço repete até acabarem as linhas

    	        Produto p = new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("preco_de_custo"));
    	        // Cria um Produto com os valores da linha atual, lendo cada coluna pelo nome:
    	        // getInt (inteiro), getString (texto), getDouble (decimal)

    	        p.setDataCadastro(rs.getObject("data_cadastro", LocalDate.class));
    	        // Lê a coluna DATE já convertida para LocalDate e guarda no produto.
    	        // Ficou separado porque o construtor usado não recebe a data

    	        produtos.add(p);
    	        // Adiciona o produto à lista
    	    }

    	    System.out.println("Listagem de Produtos Obtida com sucesso!");
    	    // Só chega aqui se o laço terminou sem exceção

    	} catch (SQLException e) {
    	    System.out.println("ERRO ao listar.  " + e.getMessage());
    	    // Se algo falhar (conexão, SQL, coluna inexistente), mostra a mensagem do erro
    	}

    	System.out.println("Exibindo produtos:");

    	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	// Formatador para exibir a data no padrão brasileiro

    	for (Produto prod : produtos) {
    	    // Percorre a lista, um produto por vez (for-each)

    	    prod.mostrarDados();
    	    // Método da classe Produto que imprime id, descrição e preço

    	    System.out.println("Data de Cadastro: " + prod.getDataCadastro().format(fmt));
    	    // Imprime a data formatada, ex.: 07/11/2025
    	}
    	}   // fecha o main
    	}   // fecha a classe