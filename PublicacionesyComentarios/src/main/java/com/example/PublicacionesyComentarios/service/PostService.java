package com.example.PublicacionesyComentarios.service;

import com.example.PublicacionesyComentarios.model.Post;
import com.example.PublicacionesyComentarios.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
public class PostService {

    private final PostRepository postRepository;

    // Constructor
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Crear un post sin depender del servicio de usuario
    public Mono<Post> createPost(String content) {
        // Usar un userId de prueba
        String testUserId = "userId-de-prueba";

        // Crear el objeto Post
        Post post = new Post();
        post.setUserId(testUserId);
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setLikes(0); // Inicializar en 0
        post.setDislikes(0); // Inicializar en 0
        post.setCommentsCount(0); // Inicializar en 0
        post.setReportStatus(false); // Inicializar en false

        // Guardar el post y devolverlo como Mono<Post>
        return postRepository.save(post);
    }
}
