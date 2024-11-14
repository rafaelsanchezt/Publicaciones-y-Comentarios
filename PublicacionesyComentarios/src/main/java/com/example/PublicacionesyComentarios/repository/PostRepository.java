package com.example.PublicacionesyComentarios.repository;

import com.example.PublicacionesyComentarios.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {
    // Puedes agregar consultas personalizadas si es necesario
}
