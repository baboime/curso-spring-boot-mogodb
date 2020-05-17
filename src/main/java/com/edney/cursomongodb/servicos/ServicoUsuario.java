package com.edney.cursomongodb.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.respositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}
}
