package Modelo;

public class Gato extends Animal {
	private String coloracao;
	public Gato(int id, String nome, String raca, int idade, double peso, char sexo, String coloracao) { // criar um construtor que aproveita o da classe-mãe:
        super(id, nome, raca, idade, peso,sexo); //chama o construtor da classe-mãe, passando os cinco argumentos
        this.coloracao = coloracao;
 }
	
	
	public  void imprimeGato() {
		this.imprimeDados();
		System.out.printf("%nColoração: %s%n", coloracao);
	}
	
	 @Override  //sobescreve o metodo da classe mae, funciona ela sendo abstrata e concreta
	    public void emitirSom() {
	        System.out.println("Miau!");
	    }
	 
	public String getColoracao() {
	    return coloracao;
	}
	
	
}
