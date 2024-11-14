package com.example.PublicacionesyComentarios.service;
import com.example.PublicacionesyComentarios.model.post;
import com.example.PublicacionesyComentarios.repository.PostRepository;
import org.springframework.stereotype.Service; 
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;


@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Mono<post> createPost(String content) {
        return userService.getUserId()
            .flatMap(userId -> {
                post post = new post();
                post.setUserId(userId);
                post.setContent(content);
                post.setCreatedAt(LocalDateTime.now());
                return postRepository.save(post);
            });
    }
}
