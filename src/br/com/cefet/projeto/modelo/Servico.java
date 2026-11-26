package br.com.cefet.projeto.modelo;

public class Servico {
		private int id;
		private String descricao;
		private double valor;
		
		public Servico(String descricao, double valor) {
			this.setDescricao(descricao);
			this.setValor(valor);
		}
		
		public Servico(int id, String descricao, double valor) {
			this(descricao, valor);
			this.setId(id);
		}
		
		
		
//get and set
		
		public int getId() {
			return this.id;
		}
		
		public String getDescricao() {
			return this.descricao;
		}
		
		public double getValor() {
			return this.valor;
		}
		
		public void setDescricao(String descricao) {
		    this.descricao = descricao;
		}


		public void setValor(double valor) {
		    this.valor = valor;
		}
		
		public void setId(int id) {
			this.id = id;
		}
}
