package com.example.productapibackend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration for API documentation.
 */
@Configuration
public class OpenApiConfig {

    // PUBLIC_INTERFACE
    @Bean
    public OpenAPI productApiOpenAPI() {
        /** Provides OpenAPI metadata (title, description, version). */
        return new OpenAPI()
                .info(new Info()
                        .title("Product Management API")
                        .description("REST API for managing products (CRUD)")
                        .version("1.0.0")
                        .contact(new Contact().name("Product API Team")))
                .externalDocs(new ExternalDocumentation()
                        .description("Swagger UI")
                        .url("/swagger-ui.html"));
    }
}
