package com.trial.springboot.Hellotry;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Allow requests from Angular application
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specified methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow sending cookies
    }
}
