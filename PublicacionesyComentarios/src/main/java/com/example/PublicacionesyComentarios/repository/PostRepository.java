package com.example.PublicacionesyComentarios.repository;

import com.example.PublicacionesyComentarios.model.post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<post, String> {
    // Métodos personalizados opcionales
}
