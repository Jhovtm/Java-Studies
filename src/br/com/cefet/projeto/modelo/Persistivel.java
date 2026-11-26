package br.com.cefet.projeto.modelo;

import java.util.List;

public interface Persistivel<T> { // interface persistivel generica
	void inserir(T t) throws DominioException;
	int alterar(T t) throws DominioException;
	List<T> listar() throws DominioException;
	T obterPeloId(int id) throws DominioException;
	int removerPeloId(int d) throws DominioException;

}
