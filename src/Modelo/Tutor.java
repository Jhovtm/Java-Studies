package Modelo;

public class Tutor {
	private String nome;
	private String endereco;
	private String telefone;
	private Animal[] animais;


	public Tutor(String nome, String endereco, String telefone, Animal[] animais) {
	    this.nome = nome;
	    this.endereco = endereco;
	    this.telefone = telefone;

	    if (animais == null || animais.length == 0) {
	        throw new IllegalArgumentException(
	            "O tutor deve ter pelo menos um animal."
	        );
	    }
	    this.animais = animais;
	    for (Animal animal : this.animais) { // associa os animais ao tutor
	        animal.setTutor(this);
	    }
	}
	    
	    //methods
	    
	    
	    
	    
	  public  void imprimeTutor() {
	    	System.out.println("\nTutor: "+nome+"\nEndereço: "+endereco+"\nTelefone: "+telefone);
	    }

	    public String getNome() {
	        return nome;
	    }
	    
	    public String getEndereco() {
	    	return endereco;
	    }

	    public String getTelefone() {
	        return telefone;
	    }
	    

		public Animal[] getAnimais() {
			return animais;
		}

		public void setAnimais(Animal[] animais) {
			this.animais = animais;
		}
	}
