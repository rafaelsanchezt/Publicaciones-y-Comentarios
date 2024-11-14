package com.example.PublicacionesyComentarios.service;

import com.example.PublicacionesyComentarios.model.Post;
import com.example.PublicacionesyComentarios.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    // Crear un post
    public Mono<Post> createPost(String content, List<String> media, List<String> tags) {
        return Mono.just("userId-de-prueba")  // Simulación del ID de usuario
            .flatMap(userId -> {
                Post post = new Post();
                post.setUserId(userId);
                post.setContent(content);
                post.setCreatedAt(LocalDateTime.now());
                post.setUpdatedAt(LocalDateTime.now());
                post.setLikes(0);
                post.setDislikes(0);
                post.setCommentsCount(0);
                post.setReportStatus(false);
                post.setMedia(media != null ? media : new ArrayList<>());
                post.setTags(tags != null ? tags : new ArrayList<>());

                return postRepository.save(post);
            });
    }

    // Incrementar likes
    public Mono<Post> incrementLikes(String postId) {
        return postRepository.findById(postId)
            .flatMap(post -> {
                post.setLikes(post.getLikes() + 1);  // Incrementar el contador de likes
                return postRepository.save(post);  // Guardar el post con el contador actualizado
            });
    }

    // Incrementar dislikes
    public Mono<Post> incrementDislikes(String postId) {
        return postRepository.findById(postId)
            .flatMap(post -> {
                post.setDislikes(post.getDislikes() + 1);  // Incrementar el contador de dislikes
                return postRepository.save(post);  // Guardar el post con el contador actualizado
            });
    }
}
