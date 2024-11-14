package com.example.PublicacionesyComentarios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "posts") // Define the collection in MongoDB
public class post {

    @Id
    private String id;
    private String userId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> media; // Lista de URLs de imágenes/videos
    private List<String> tags; // Lista de tags
    private int likes; // Número de "me gusta"
    private int dislikes; // Número de "no me gusta"
    private int commentsCount; // Número de comentarios
    private boolean reportStatus; // Indica si la publicación fue reportada o no

    // Constructor vacío necesario para algunos frameworks
    public post() {}

    // Constructor con parámetros
    public post(String userId, String content, LocalDateTime createdAt, LocalDateTime updatedAt, 
                List<String> media, List<String> tags, int likes, int dislikes, 
                int commentsCount, boolean reportStatus) {
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.media = media;
        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentsCount = commentsCount;
        this.reportStatus = reportStatus;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public boolean isReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(boolean reportStatus) {
        this.reportStatus = reportStatus;
    }
}
