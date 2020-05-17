package com.edney.cursomongodb.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edney.cursomongodb.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {
	
	@RequestMapping(method = RequestMethod.GET) // pode ser utilizado o '@GetMapping'
	public ResponseEntity<List<Usuario>> buscarTodos() {
		Usuario maria = new Usuario("1", "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario("2", "Alex Green", "alex@gmail.com");
		List<Usuario> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(lista);
	}
 
}
