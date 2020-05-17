package com.edney.cursomongodb.respositorios;

import java.util.Date;
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
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } },  { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> buscaCompleta(String texto, Date dataInicio, Date dataFim);
}
