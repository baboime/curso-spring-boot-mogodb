package com.edney.cursomongodb.respositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edney.cursomongodb.entidades.Post;

@Repository
public interface RepositorioPost extends MongoRepository<Post, String> {
}
