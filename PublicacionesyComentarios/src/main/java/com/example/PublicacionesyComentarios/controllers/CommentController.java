package com.example.PublicacionesyComentarios.controllers;

import com.example.PublicacionesyComentarios.model.Comment;
import com.example.PublicacionesyComentarios.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    // Constructor sin @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable String postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable String userId) {
        return commentService.getCommentsByUserId(userId);
    }

    @PostMapping
    public Comment createComment(@RequestParam String postId, @RequestParam String userId, @RequestParam String content) {
        return commentService.createComment(postId, userId, content);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
    }
}
