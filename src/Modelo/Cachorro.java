package Modelo;

public class Cachorro extends Animal implements Emitivel {
	
	private String porte;
	 public Cachorro(int id, String nome, String raca, int idade, double peso, char sexo, String porte) { // criar um construtor que aproveita o da classe-mãe:
	        super(id, nome, raca, idade, peso,sexo); //chama o construtor da classe-mãe, passando os cinco argumentos
	        this.porte = porte;
	 }
	 
	 //metodos do cachorro
	 

	 @Override
	 public  void imprimeDados() {
		 System.out.println("-------Cadastro-------"); 
		 System.out.printf("%n%nNome: %s %nIdade: %d %nRaca: %s %nPeso: %.2f %nSexo: %c %nPorte: %s", getNome(), getIdade(), getRaca(), getPeso(),getSexo(), getPorte());
			//System.out.printf("%nTutor: %s%nTelefone: $s %nEndereço:%s", tutor.getNome(), tutor.getTelefone(), tutor.getTelefone());
		 if(getTutor() != null) {
				getTutor().imprimeTutor();
			}
		}
	 @Override
	 public void emitirSom() {
		 System.out.println("\nAu, au!");
	 }
		 
	 public String getPorte() {
		    return porte;
		}
}
