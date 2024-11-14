package com.example.PublicacionesyComentarios.controllers;

import com.example.PublicacionesyComentarios.service.PostService;
import com.example.PublicacionesyComentarios.model.Post;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public Mono<ResponseEntity<Post>> createPost(@RequestBody Map<String, Object> request) {
        String content = (String) request.get("content");
        List<String> media = (List<String>) request.get("media");
        List<String> tags = (List<String>) request.get("tags");

        // Si no hay 'media' o 'tags' en la solicitud, se asignan listas vacías
        return postService.createPost(content, media != null ? media : new ArrayList<>(), tags != null ? tags : new ArrayList<>())
            .map(post -> ResponseEntity.status(HttpStatus.CREATED).body(post))
            .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
