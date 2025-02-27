package com.appsdeveloperblog.app.ws.mobile_app_ws.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;
import java.util.List;

public class CorsConfig implements CorsConfigurationSource {
    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(
            List.of("http://localhost", "http://127.0.0.1")
        );
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setMaxAge(3600L);
        return configuration;
    }
}

