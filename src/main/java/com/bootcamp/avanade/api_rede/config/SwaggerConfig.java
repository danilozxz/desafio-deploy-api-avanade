package com.bootcamp.avanade.api_rede.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                )
                .info(new Info()
                        .title("Documentação API: decola.feed")
                        .version("V1")
                        .description("A API decola.feed é responsável por gerenciar usuários, publicações e comentários em uma rede social. Ela oferece endpoints para criação, atualização, recuperação e remoção de usuários, posts e comentários."))
                .tags(
                        Arrays.asList(
                                new Tag().name("User").description("Requisições entidade User"),
                                new Tag().name("Post").description("Requisições da entidade Post"),
                                new Tag().name("Comment").description("Requisições da entidade Comment")
                        )
                );
    }
}

