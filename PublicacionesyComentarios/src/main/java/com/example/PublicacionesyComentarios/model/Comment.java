package com.example.PublicacionesyComentarios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    
    private String postId;  // Aquí se mantiene el campo
    private String userId;
    private String content;
    private LocalDateTime createdAt;
    private int likes;
    private int dislikes;
    private List<Reply> replies;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

   public Comment(String postId, String userId, String content, LocalDateTime createdAt) {
    this.postId = postId;
    this.userId = userId;
    this.content = content;
    this.createdAt = createdAt;
    this.likes = 0;  // Valor predeterminado
    this.dislikes = 0;  // Valor predeterminado
    this.replies = new ArrayList<>();  // Valor predeterminado
}

    
    // Clase interna para representar las respuestas
    public static class Reply {
        private String userId;
        private String content;
        private LocalDateTime createdAt;
        private int likes;

        // Constructor
        public Reply(String userId, String content, LocalDateTime createdAt, int likes) {
            this.userId = userId;
            this.content = content;
            this.createdAt = createdAt;
            this.likes = likes;
        }

        // Getters y Setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
    }
}
