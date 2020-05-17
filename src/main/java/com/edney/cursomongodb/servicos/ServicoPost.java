package com.edney.cursomongodb.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.cursomongodb.entidades.Post;
import com.edney.cursomongodb.respositorios.RepositorioPost;
import com.edney.cursomongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@Service
public class ServicoPost {

	@Autowired
	private RepositorioPost repositorio;

	public Post buscarPeloId(String id) {
		Optional<Post> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("Objeto não encotrado"));
	}
	
	public List<Post> buscarPeloTitulo(String texto) {
//		return repositorio.findByTituloContainingIgnoreCase(texto);
		return repositorio.buscaPorTitulo(texto);
	}
}
