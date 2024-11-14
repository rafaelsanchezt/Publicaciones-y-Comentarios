package com.example.PublicacionesyComentarios.service;
import com.example.PublicacionesyComentarios.model.Post;
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

    public Mono<Post> createPost(String content) {
        return userService.getUserId()
            .flatMap(userId -> {
                Post post = new Post();
                post.setUserId(userId);
                post.setContent(content);
                post.setCreatedAt(LocalDateTime.now());
                return postRepository.save(Post);
            });
    }
}
