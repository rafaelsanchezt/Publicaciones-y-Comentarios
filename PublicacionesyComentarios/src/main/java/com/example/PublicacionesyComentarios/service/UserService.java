package com.example.PublicacionesyComentarios.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final WebClient webClient;

    // Constructor sin @Autowired
    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://1-servicio-autenticacion-production-42b4.up.railway.app/").build();
    }

    public Mono<String> getUserId() {
        return this.webClient.get()
            .uri("/userId")
            .retrieve()
            .bodyToMono(String.class);
    }
}
