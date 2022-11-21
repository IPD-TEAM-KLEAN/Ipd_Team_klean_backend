package com.example.ipd_team_klean.Config;


import com.example.ipd_team_klean.Repository.AdminRepository.AdminRepository;
import com.example.ipd_team_klean.security.JwtAuthenticationFilter;
import com.example.ipd_team_klean.security.JwtAuthorizationFilter;
import com.example.ipd_team_klean.security.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TokenProvider tokenprovider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf()
                .disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/ipd").permitAll()
                .antMatchers("/login/**").permitAll()
                .anyRequest().permitAll();
        http.cors();
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager(),tokenprovider), UsernamePasswordAuthenticationFilter.class);
        http.addFilter(new JwtAuthorizationFilter(authenticationManager(),tokenprovider,adminRepository));


    }
}
