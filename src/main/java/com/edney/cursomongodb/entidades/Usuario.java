package com.edney.cursomongodb.entidades;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	
//	private List<Post> post = new ArrayList<>();
	
	public Usuario() {
	}

//	public Usuario(String id, String nome, String email, List<Post> post) {
	public Usuario(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
//		this.post = post;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public List<Post> getPost() {
//		return post;
//	}
//
//	public void setPost(List<Post> post) {
//		this.post = post;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
