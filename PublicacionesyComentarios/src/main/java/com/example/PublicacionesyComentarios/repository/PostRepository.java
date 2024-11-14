package com.example.PublicacionesyComentarios.repository;

import com.example.PublicacionesyComentarios.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}
