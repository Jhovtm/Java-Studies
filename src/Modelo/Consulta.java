package Modelo;
import java.time.LocalDate;
import java.time.LocalTime;


public class Consulta {
	private LocalDate data;
	private LocalTime horario;
	private Animal animal;
	private double valor;
	public boolean pagamento;
	private MedicoVeterinario veterinario;
	
	//construtor
	public Consulta(LocalDate data, LocalTime horario, Animal animal, double valor, boolean pagamento, MedicoVeterinario veterinario) {
		this.data = data;
		this.horario = horario;
		this.animal = animal;
		this.valor = valor; 
		if(valor==0) {
			pagamento = true;
		}
		this.pagamento = pagamento;
		this.veterinario = veterinario;
		if(veterinario == null) {
			throw new IllegalArgumentException("ERRO! Campo 'Veterinario' ausente.");
		}
		
	}
	
	//methods
	
	public void imprimeConsulta() {
	 System.out.println("--------Consulta--------");
	 System.out.println("Data: "+data+"\nHorário: "+horario+"\nAnimal: "+animal.getNome()+"\nValor da consulta: "+valor);
	 if(pagamento == false) {
		 System.out.println("\nPagamento pendente.");
	 } else {
		 System.out.println("Pagamento efetuado");
	 }
	 if(animal.getTutor()!=null) {
		 System.out.println("\nTutor: "+animal.getTutor().getNome());
		 System.out.println("\nTelefone: "+animal.getTutor().getTelefone());
	 }
	 System.out.println("Veterinário: "+veterinario.getNome());
	 
	}
	
	
	//getters
	LocalDate getData() {
		return data;
	}
	
	LocalTime getHorario() {
		return horario;
	}


	public Animal getAnimal() {
		return animal;
	}

	
	public double getValor() {
		return valor;
	}
	
	public MedicoVeterinario getVeterinario() {
		return veterinario;
	}
	//setters

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
	
}
