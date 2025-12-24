package com.groupeisi.m2gl.ms_marchand_g4.configurattion;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Marchand")
                        .description("API GraphQL pour la gestion des marchands")
                        .version("1.0"));
    }
    @Bean
    public HttpMessageConverters httpMessageConverters() {
        return new HttpMessageConverters(
                new MappingJackson2HttpMessageConverter()
        );
    }
}
