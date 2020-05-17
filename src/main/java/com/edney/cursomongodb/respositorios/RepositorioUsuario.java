package com.edney.cursomongodb.respositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edney.cursomongodb.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
}
