package com.edney.cursomongodb.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edney.cursomongodb.dto.DTOUsuario;
import com.edney.cursomongodb.entidades.Post;
import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servico;
		
	@RequestMapping(method = RequestMethod.GET) // pode ser utilizado o '@GetMapping'
	public ResponseEntity<List<DTOUsuario>> buscarTodos() {
		List<Usuario> lista = servico.buscarTodos();
		List<DTOUsuario> listaDto = lista.stream().map(x -> new DTOUsuario(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DTOUsuario> buscarPorId(@PathVariable String id) {
		Usuario obj = servico.buscarPeloId(id);
		return ResponseEntity.ok().body(new DTOUsuario(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> incluir(@RequestBody DTOUsuario objDTO) {
		Usuario obj = servico.aPartirDoDTO(objDTO);
		obj = servico.incluir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable String id) {
		servico.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody DTOUsuario objDTO, @PathVariable String id) {
		Usuario obj = servico.aPartirDoDTO(objDTO);
		obj.setId(id);
		obj = servico.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> buscarPost(@PathVariable String id) {
		Usuario obj = servico.buscarPeloId(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
