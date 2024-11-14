package com.example.PublicacionesyComentarios.controllers;

import com.example.PublicacionesyComentarios.model.Post;
import com.example.PublicacionesyComentarios.service.PostService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Endpoint para crear un post
    @PostMapping
    public Mono<ResponseEntity<Post>> createPost(@RequestBody Map<String, String> request) {
        String content = request.get("content");

        return postService.createPost(content)
            .map(post -> ResponseEntity.status(HttpStatus.CREATED).body(post));
    }
    

    // Incrementar likes
    @PostMapping("/{postId}/like")
    public Mono<ResponseEntity<Post>> likePost(@PathVariable String postId) {
        return postService.incrementLikes(postId)
            .map(post -> ResponseEntity.ok(post));
    }

    // Incrementar dislikes
    @PostMapping("/{postId}/dislike")
    public Mono<ResponseEntity<Post>> dislikePost(@PathVariable String postId) {
        return postService.incrementDislikes(postId)
            .map(post -> ResponseEntity.ok(post));
    }

}







