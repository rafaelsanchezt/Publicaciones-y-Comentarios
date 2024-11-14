package com.example.PublicacionesyComentarios.controllers;

import com.example.PublicacionesyComentarios.service.PostService;
import com.example.PublicacionesyComentarios.model.Post;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Endpoint para crear un post
    @PostMapping
    public Mono<ResponseEntity<Post>> createPost(@RequestBody Map<String, Object> request) {
        String content = (String) request.get("content");

        // Manejo de 'media' con tipo seguro
        List<String> media = getListFromRequest(request, "media");

        // Manejo de 'tags' con tipo seguro
        List<String> tags = getListFromRequest(request, "tags");

        // Si no hay 'media' o 'tags' en la solicitud, se asignan listas vacías
        return postService.createPost(content, media, tags)
            .map(post -> ResponseEntity.status(HttpStatus.CREATED).body(post))
            .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    // Endpoint para incrementar los likes de un post
    @PostMapping("/{postId}/like")
    public Mono<ResponseEntity<Post>> likePost(@PathVariable String postId) {
        return postService.incrementLikes(postId)
            .map(post -> ResponseEntity.status(HttpStatus.OK).body(post))
            .onErrorReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint para incrementar los dislikes de un post
    @PostMapping("/{postId}/dislike")
    public Mono<ResponseEntity<Post>> dislikePost(@PathVariable String postId) {
        return postService.incrementDislikes(postId)
            .map(post -> ResponseEntity.status(HttpStatus.OK).body(post))
            .onErrorReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método auxiliar para obtener listas de tipo String de la solicitud
    private List<String> getListFromRequest(Map<String, Object> request, String key) {
        Object value = request.get(key);
        if (value instanceof List<?>) {
            // Verificamos que todos los elementos en la lista sean de tipo String
            List<?> rawList = (List<?>) value;
            List<String> resultList = new ArrayList<>();
            for (Object item : rawList) {
                if (item instanceof String) {
                    resultList.add((String) item);  // Solo agregamos elementos de tipo String
                } else {
                    // Si encontramos un elemento no String, retornamos lista vacía
                    return new ArrayList<>();
                }
            }
            return resultList;
        }
        return new ArrayList<>();  // Si no es una lista o está vacío, retornamos lista vacía
    }
}
