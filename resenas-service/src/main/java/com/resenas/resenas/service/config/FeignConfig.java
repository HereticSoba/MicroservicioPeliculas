package com.resenas.resenas.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {
    @Bean
    RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof JwtAuthenticationToken jwt) {
                requestTemplate.header("Authorization","Bearer " + jwt.getToken().getTokenValue()
                );
            }
        };
    }
}