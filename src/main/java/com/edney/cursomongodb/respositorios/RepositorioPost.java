package com.edney.cursomongodb.respositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.edney.cursomongodb.entidades.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> buscaPorTitulo(String texto);
	
	List<Post> findByTituloContainingIgnoreCase(String texto);
}
