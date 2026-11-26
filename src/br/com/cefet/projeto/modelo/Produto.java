package br.com.cefet.projeto.modelo;

import java.time.LocalDate;

public class Produto {
	private int id;
	private String descricao;
	private double precoDeCusto;
	private LocalDate dataCadastro;
	
	public Produto(String descricao, double precoDeCusto) {
		this.setDescricao(descricao);
		this.setPrecoDeCusto(precoDeCusto);
	}
	
	public Produto(String descricao, double precoDeCusto, LocalDate dataCadastro) {
		this(descricao, precoDeCusto);
		this.setDataCadastro(dataCadastro);
	}
	
	public Produto(int id, String descricao, double precoDeCusto) {
		this(descricao, precoDeCusto);
		this.setId(id);
	}
	
	public Produto(int id, String descricao, double precoDeCusto, LocalDate dataCadastro) {
		this(descricao, precoDeCusto, dataCadastro);
		this.setId(id);
	}
	
    public void mostrarDados(){
        System.out.println("Id: "+this.id+" - Descrição: "+this.descricao+" - Preço: R$"+this.precoDeCusto);
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoDeCusto() {
		return precoDeCusto;
	}
	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
