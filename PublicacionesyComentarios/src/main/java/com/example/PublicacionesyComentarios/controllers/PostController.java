package com.example.PublicacionesyComentarios.controllers;
import com.example.PublicacionesyComentarios.service.PostService;
import com.example.PublicacionesyComentarios.model.post;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import java.util.Map;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Mono<ResponseEntity<post>> createPost(@RequestBody Map<String, String> request) {
        String content = request.get("content");
        return postService.createPost(content)
            .map(post -> ResponseEntity.status(HttpStatus.CREATED).body(post));
    }
}
