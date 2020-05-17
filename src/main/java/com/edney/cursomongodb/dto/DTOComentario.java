package com.edney.cursomongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class DTOComentario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String texto;
	private Date data;
	private DTOAutor autor;
	
	public DTOComentario() {
	}

	public DTOComentario(String texto, Date data, DTOAutor autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public DTOAutor getAutor() {
		return autor;
	}

	public void setAutor(DTOAutor autor) {
		this.autor = autor;
	}
}
