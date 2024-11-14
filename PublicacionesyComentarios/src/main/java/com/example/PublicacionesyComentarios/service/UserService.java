package com.example.PublicacionesyComentarios.service;

import org.springframework.stereotype.Service; // Asegúrate de tener esta línea importada

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final WebClient webClient;

    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://usuario-microservicio/api").build();
    }

    public Mono<String> getUserId() {
        return this.webClient.get()
            .uri("/userId")
            .retrieve()
            .bodyToMono(String.class);
    }
}
