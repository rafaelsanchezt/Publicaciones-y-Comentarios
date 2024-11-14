package com.example.PublicacionesyComentarios.repository;

import com.example.PublicacionesyComentarios.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByPostId(String postId);
    List<Comment> findByUserId(String userId);
}
