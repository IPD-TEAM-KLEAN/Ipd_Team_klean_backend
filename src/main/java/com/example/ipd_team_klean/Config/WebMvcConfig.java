package com.example.ipd_team_klean.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// mvc cors

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private  final long MAX_AGE_SECS= 3600;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedOrigins("http://211.57.119.81:3000")
                .allowedOrigins("http://211.57.119.81")
                .allowedOrigins("http://klean.site")
                .allowedOrigins("http://www.klean.site")
                .allowedMethods("GET","POST","PUT","PATH","DELETE","OPTIONS")
                .allowedHeaders("Access-Control-Allow-origin","*")
                .allowCredentials(true)
                .exposedHeaders("Authorization","*")
                .maxAge(MAX_AGE_SECS);
    }
}
