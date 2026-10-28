package Modelo;

public class Animal {
	//classes privadas so podem ser acessadas por getters
	private int id;
	private String nome;
	private String raca;
	private int idade;
	private double peso;
	private char sexo;
	 private Tutor tutor; // a classe tutor vira um atributo de Animal
	
	//construtor da classe
	public Animal(int id, String nome,String raca, int idade, double peso, char sexo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.raca = raca;
		this.peso = peso;
		this.sexo = sexo;
	}
	
	//metodos
	
	public void imprimeDados() {
		System.out.println("-------Cadastro-------");
		System.out.printf("%n%nNome: %s %nIdade: %d %nRaca: %s %nPeso: %.2f %nSexo: %c", nome, idade, raca, peso,sexo);
		//System.out.printf("%nTutor: %s%nTelefone: $s %nEndereço:%s", tutor.getNome(), tutor.getTelefone(), tutor.getTelefone());
		if(getTutor() != null) {
			getTutor().imprimeTutor();
		}
	}
	
	public void emitirSom() {
        System.out.println("Som de animal");
    }

	
	
	//getters
	public int getID() {
		return id;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	 public Tutor getTutor() {
	     return tutor;
	 }

	 public void setTutor(Tutor tutor) {
	     this.tutor = tutor;
	 }


}



