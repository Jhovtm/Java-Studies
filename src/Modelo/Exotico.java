package Modelo;

public class Exotico extends Animal {
	String especie;
	String tipo;
	public Exotico(int id, String nome, String raca, int idade, double peso, char sexo, String especie, String tipo) {
		super(id, nome, raca, idade, peso, sexo);
		this.especie = especie;
		this.tipo = tipo;
	}
	
	public void imprimeExotico() {
		this.imprimeDados();
		System.out.println("\nEspecie: "+this.especie+"\nTipo: "+this.tipo);
	}
	
	public String getTipo() {
		return tipo;
	}
	public String getEspecie() {
		return especie;
	}
}
