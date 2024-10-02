package com.example.gatewayaa;

import com.google.common.net.HttpHeaders;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

    @Bean
    public GlobalFilter customFilter() {
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);  // Supprimer le préfixe "Bearer "

                // Appeler JwtSecurity pour valider le token JWT
                WebClient webClient = WebClient.create("http://localhost:port-of-JwtSecurity");
                Mono<Boolean> isValid = webClient.post()
                        .uri("/auth/validate")
                        .header(HttpHeaders.AUTHORIZATION, authHeader)
                        .retrieve()
                        .bodyToMono(Boolean.class);

                return isValid.flatMap(valid -> {
                    if (valid) {
                        return chain.filter(exchange);  // Token valide, continue la requête
                    } else {
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return exchange.getResponse().setComplete();
                    }
                });
            }

            // Si pas de token ou token invalide
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        };
    }
}
