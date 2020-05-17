package com.edney.cursomongodb.servicos.excecoes;

public class ExcecaoObjetoNaoEncontrado extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ExcecaoObjetoNaoEncontrado(String msg) {
		super(msg);
	}

}
