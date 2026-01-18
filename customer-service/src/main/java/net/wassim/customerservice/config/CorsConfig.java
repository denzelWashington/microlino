package net.wassim.customerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")          // Tous les endpoints
                        .allowedOrigins("*")            // ✅ Toutes les origines
                        .allowedMethods("*")            // Toutes les méthodes HTTP
                        .allowedHeaders("*")            // Tous les headers
                        .allowCredentials(false);       // Doit être false avec "*"
            }
        };
    }
}