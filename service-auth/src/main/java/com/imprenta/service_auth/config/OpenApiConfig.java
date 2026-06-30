package com.imprenta.service_auth.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "API Autenticación", version = "1.0"),
        servers = @Server(url = "http://localhost:8080")
)
public class OpenApiConfig {
}