package Tests;

import java.time.LocalDate;
import java.time.LocalTime;
import Modelo.Animal;
import Modelo.Tutor;
import Modelo.Consulta;
import Modelo.MedicoVeterinario;
import Modelo.Funcionario;
import Modelo.Cachorro;

public class ConsultaTest {
	public static void main(String[] args) { 
	
	Animal animal = new Cachorro(1, "Bidu", "Schnauzer", 5, 21.23, 'M', "Grande");
	Animal[] a = {animal};

	Tutor t = new Tutor(
		    "Franjinha",
		    "Bairro do Limoeiro",
		    "21997212211",
		    a
		);
	
	Funcionario doutor = new MedicoVeterinario(10,"Mariana Thomaz", "12345678911", 5.900, "Ortopedista");

	Consulta consulta = new Consulta(
			LocalDate.of(2018, 1, 1), 
			LocalTime.of(8, 30), 
			animal, 
			210.60, 
			false,
			(MedicoVeterinario) doutor
			);
	
	  consulta.imprimeConsulta();

	  Consulta outraConsulta = new Consulta(
				LocalDate.of(2019, 10, 1), 
				LocalTime.of(14, 40), 
				animal, 
				0, 
				false,
				(MedicoVeterinario) doutor
				);
		
		  outraConsulta.imprimeConsulta();


}
}