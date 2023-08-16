package com.paulocavalcante.unichristusteste.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

      return http.csrf(csrf -> csrf.disable())
         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
         .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
            .requestMatchers(HttpMethod.POST, "/destino", "/veiculo").hasRole("ADMIN") 
                  
         )
         .build();
    }
    
}
