package com.edney.cursomongodb.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edney.cursomongodb.dto.DTOUsuario;
import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.respositorios.RepositorioUsuario;
import com.edney.cursomongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> buscarTodos() {
		return repositorio.findAll();
	}

	public Usuario buscarPeloId(String id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("Objeto não encotrado"));
	}
	
	public Usuario incluir(Usuario obj) {
		return repositorio.insert(obj);
	}
	
	public void excluir(String id) {
		buscarPeloId(id);
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Usuario obj) {
		Usuario objASerAtualizado = buscarPeloId(obj.getId());
		atualizarDados(objASerAtualizado, obj);
		return repositorio.save(objASerAtualizado);
	}
	
	private void atualizarDados(Usuario objASerAtualizado, Usuario obj) {
		objASerAtualizado.setNome(obj.getNome());
		objASerAtualizado.setEmail(obj.getEmail());
	}

	public Usuario aPartirDoDTO (DTOUsuario objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}
}
