package com.edney.cursomongodb.dto;

import java.io.Serializable;

import com.edney.cursomongodb.entidades.Usuario;

public class DTOAutor implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	
	public DTOAutor() {
	}
	
	public DTOAutor(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
}
