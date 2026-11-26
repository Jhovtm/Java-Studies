package br.com.cefet.projeto.testes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.cefet.projeto.modelo.Produto;

public class TestaProduto {
	public static void main(String[] args) {
		Produto p = new Produto("Ovos dúzia", 10);
		//Defininda data atual
		p.setDataCadastro(LocalDate.now());
		//Definindo uma data especícica sem formatter
		p.setDataCadastro(LocalDate.of(2025, 11, 06));
		
		//Utilizando formatter (Bem mais simples)
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		p.mostrarDados();
		String dataEmTexto = p.getDataCadastro().format(fmt);
		System.out.println("Data de cadastro: "+dataEmTexto);
		
		p.setDataCadastro(LocalDate.parse("25/07/2025",fmt));
		dataEmTexto = p.getDataCadastro().format(fmt);
		System.out.println("Data de cadastro: "+dataEmTexto);
	}
}
