package com.example.PublicacionesyComentarios;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.example.PublicacionesyComentarios.repository")
public class PublicacionesyComentariosApplication {
    public static void main(String[] args) {
        SpringApplication.run(PublicacionesyComentariosApplication.class, args);
    }
}
