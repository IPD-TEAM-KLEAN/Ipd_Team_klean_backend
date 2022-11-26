package com.example.ipd_team_klean.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// webSecurity cors
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답을 할시 json을 자바스크립트에서 처리할 수 있게 할지 결정
        config.addAllowedOrigin("http://localhost:3000"); // origin localhost:3000 만 허용
        config.addAllowedOrigin("http://211.57.119.81:3000");
        config.addAllowedOrigin("http://211.57.119.81");
        config.addAllowedOrigin("http://klean.site");
        config.addAllowedOrigin("http://www.klean.site");
        config.addAllowedHeader("*"); // 모든 header 응답 허용
        config.addAllowedHeader("Access-Control-Allow-origin");
        config.addAllowedMethod("*"); // 모든 post,get,put,delete, patch요청 허용
        config.addExposedHeader("Authorization");

        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }

}
