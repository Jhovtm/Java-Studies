package Tests;

import Modelo.Cachorro; //modelo e test sao packages diferentes
import Modelo.Exotico;
import Modelo.Animal;
import Modelo.Gato;
import java.util.ArrayList;
import Modelo.Tutor;

public class AnimalTest {
	public static void main(String[] args) {
		Cachorro animalUm = new Cachorro (1, "Bidu", "Schnauzer", 5, 21.23, 'M', "Grande");
		Gato animalDois = new Gato(2, "Mingau", "Indefinida", 2, 4.2, 'M', "Branco" );
		Exotico animalTres = new Exotico(3, "Louro", null, 12, 0.8,'M', "Papagaio", "Selvagem");
		Animal[] a = {animalUm, animalTres};
		

		Tutor t = new Tutor(
		    "Franjinha",
		    "Bairro do Limoeiro",
		    "21997212211",
		    a
		);
		
	animalUm.imprimeDados();
	animalUm.emitirSom();
	animalDois.imprimeGato();
	animalDois.emitirSom();
	animalTres.imprimeExotico();
	
	
	
	//Animal[] a1 = null;
			//Tutor tutor = new Tutor("Salsicha", "Bairro xyz", "234455", a1);4
	//tutor.imprimeTutor(); //-> descomentando aparecerá o erro de que o tutor deve ter pelo menos um animal
		
	
	
	}
}
