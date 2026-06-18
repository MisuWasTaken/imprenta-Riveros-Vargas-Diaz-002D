package com.imprenta.api_gateway.filter;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Value("${jwt.auth.url}")
    private String secretito;
    public AuthenticationFilter() {
        super(Config.class);
    }
    public static class Config {
        // hola aqui van configuraciones por si llegaramos a necesitarlas jeje like like
    }   
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")){
                return onError(exchange, err:"Token incorrecto o formato invalido", HttpStatus.UNAUTHORIZED);
            }
            String token = authHeader.substring(7);
            try {
                Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretito.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token);
            } catch (Exception e) {
                return onError(exchange, err:"Token invalido", HttpStatus.UNAUTHORIZED);
            }
            return chain.filter(exchange);
        };
    }
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        exchange.getResponse().setStatusCode(httpStatus);
        return exchange.getResponse().setComplete();
    }
    
}
