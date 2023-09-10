package com.paulocavalcante.unichristusteste.config;

import com.paulocavalcante.unichristusteste.config.filter.JwtAuthFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final JwtAuthFilter jwtFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

      return http.csrf(AbstractHttpConfigurer::disable)
         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
         .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(HttpMethod.POST, "/user").permitAll()
            .requestMatchers(HttpMethod.POST, "/destino", "/veiculo").hasRole("ADMIN")
                 .anyRequest().permitAll()
         )
              .authenticationProvider(authenticationProvider)
              .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
         .build();
    }
    
}
