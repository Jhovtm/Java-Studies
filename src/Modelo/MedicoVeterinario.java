package Modelo;


public class MedicoVeterinario extends Funcionario {
		
		private String especialidade;
		private Consulta[] consulta;
		
		public MedicoVeterinario(int id, String nome, String cpf, double salario, String especialidade) {
			super(id, nome, cpf, salario);
			this.especialidade = especialidade;
			//this.setConsulta(consulta);
		}
		
		public String getEspecialidade() {
			return especialidade;
		}

		public Consulta[] getConsulta() {
			return consulta;
		}

		public void setConsulta(Consulta[] consulta) {
			this.consulta = consulta;
		}
		
		
}
