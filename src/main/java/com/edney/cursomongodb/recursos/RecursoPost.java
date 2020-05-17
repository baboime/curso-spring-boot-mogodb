package com.edney.cursomongodb.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edney.cursomongodb.entidades.Post;
import com.edney.cursomongodb.recursos.util.URL;
import com.edney.cursomongodb.servicos.ServicoPost;

@RestController
@RequestMapping(value = "/posts")
public class RecursoPost {
	
	@Autowired
	private ServicoPost servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> buscarPorId(@PathVariable String id) {
		Post obj = servico.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/buscaportitulo")
	public ResponseEntity<List<Post>> buscarPorTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.parametroDeDecodificacao(texto);
		List<Post> lista = servico.buscarPeloTitulo(texto);
		return ResponseEntity.ok().body(lista);
	}
}
