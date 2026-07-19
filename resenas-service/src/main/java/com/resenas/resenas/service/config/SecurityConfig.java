package com.resenas.resenas.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // Swagger
                        .requestMatchers("/swagger-ui/**","/v3/api-docs/**","/swagger-ui.html").permitAll()

                        // Consultar películas
                        .requestMatchers(HttpMethod.GET, "/v1/resenas/**").hasAnyRole("USER", "ADMIN")

                        // Registrar películas
                        .requestMatchers(HttpMethod.POST, "/v1/resenas/**").hasAnyRole("ADMIN", "USER")

                        // Actualizar películas
                        .requestMatchers(HttpMethod.PUT, "/v1/resenas/**").hasRole("ADMIN")

                        // Eliminar películas
                        .requestMatchers(HttpMethod.DELETE, "/v1/resenas/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )

                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt->
                        		jwt.jwtAuthenticationConverter(new JwtAuthConverter())
                        		)
                        );

        return http.build();
    }
}