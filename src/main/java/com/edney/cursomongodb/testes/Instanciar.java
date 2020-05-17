package com.edney.cursomongodb.testes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.edney.cursomongodb.entidades.Usuario;
import com.edney.cursomongodb.respositorios.RepositorioUsuario;

@Configuration
public class Instanciar implements CommandLineRunner{

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		repositorioUsuario.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		repositorioUsuario.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
