package com.example.PublicacionesyComentarios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "comments")
public class Comment {
    
    @Id
    private String id;
    private String postId;         // ID de la publicación relacionada
    private String userId;         // ID del usuario que comenta
    private String content;        // Contenido del comentario
    private LocalDateTime createdAt; // Fecha de creación del comentario

    // Constructor sin argumentos
    public Comment() {}

    // Constructor con argumentos
    public Comment(String postId, String userId, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPostId() { return postId; }
    public void setPostId(String postId) { this.postId = postId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
