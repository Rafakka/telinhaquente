package br.com.logos.telinhaquente.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebFluxConfigurer corsConfigurer(){
        return new WebFluxConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://frontend.localhost")
                        .allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
            }
        };
    }
}