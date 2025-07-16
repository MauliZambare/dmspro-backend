package com.dmspro.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/users/register", 
                    "/api/users/login", 
                    "/api/customers/**", 
                    "/api/entries/**" ,
                    "/api/users/**",
                    "/h2-console/**"
                ).permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // ✅ Optional: no session
        .headers(headers -> headers.frameOptions().disable())  // ✅ To allow H2 console if needed
        .httpBasic(); // Optional: can also remove if JWT used

    return http.build();
}
}