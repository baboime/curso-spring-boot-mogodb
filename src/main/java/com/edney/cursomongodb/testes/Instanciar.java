package com.edney.cursomongodb.testes;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.edney.cursomongodb.dto.DTOAutor;
import com.edney.cursomongodb.dto.DTOComentario;
import com.edney.cursomongodb.entidades.Post;
import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.respositorios.RepositorioPost;
import com.edney.cursomongodb.respositorios.RepositorioUsuario;

@Configuration
public class Instanciar implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioPost repositorioPost;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repositorioUsuario.deleteAll();
		repositorioPost.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		repositorioUsuario.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo Abraços", new DTOAutor(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new DTOAutor(maria));
		
		DTOComentario c1 = new DTOComentario("Boa viagem mano!", sdf.parse("21/03/2018"), new DTOAutor(alex));
		DTOComentario c2 = new DTOComentario("Aproveite", sdf.parse("22/03/2018"), new DTOAutor(bob));
		DTOComentario c3 = new DTOComentario("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new DTOAutor(alex));
		
		post1.getComentarios().addAll(Arrays.asList(c1, c2));
		post2.getComentarios().addAll(Arrays.asList(c3));
		
		repositorioPost.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		repositorioUsuario.save(maria);
		
	}

}
