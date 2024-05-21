package com.etiya.common.configuration;

import com.etiya.common.filters.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@RequiredArgsConstructor
@Service
public class BaseSecurityService {
    private static final String[] WHITE_LIST_URLS = {
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/api/v1/auth/**"
    };
    private final JwtAuthFilter jwtAuthFilter;

    public HttpSecurity configureCoreSecurity(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req-> req.requestMatchers("WHITE_LIST_URLS").permitAll())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity;
    }
}
