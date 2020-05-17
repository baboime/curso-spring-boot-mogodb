package com.edney.cursomongodb.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edney.cursomongodb.dto.UsuarioDTO;
import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servico;
		
	@RequestMapping(method = RequestMethod.GET) // pode ser utilizado o '@GetMapping'
	public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
		List<Usuario> lista = servico.buscarTodos();
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
 
}
