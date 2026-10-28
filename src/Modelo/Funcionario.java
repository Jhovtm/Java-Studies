package Modelo;

public abstract class Funcionario {
	private int id;
	private String nome;
	private String cpf;
	private double salario;
	
	public Funcionario(int id, String nome, String cpf, double salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	
	int getId() {
		return id;
	}
	
	String getNome() {
		return nome;
	}
	
	String getCpf() {
		return cpf;
	}
	
	double getSalario() {
		return salario;
	}
}

	
