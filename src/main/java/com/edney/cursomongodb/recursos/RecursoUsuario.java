package com.edney.cursomongodb.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.servicos.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@Autowired
	private ServicoUsuario servico;
		
	@RequestMapping(method = RequestMethod.GET) // pode ser utilizado o '@GetMapping'
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
 
}
