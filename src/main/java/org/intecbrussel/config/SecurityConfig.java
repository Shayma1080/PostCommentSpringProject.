package org.intecbrussel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // activeren Spring Security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF = Cross-Site Request Forgery
                .csrf(csrf -> csrf.disable()) // CSRF uitschakelen (optioneel voor API's)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .authenticated())
                .httpBasic(httpBasic -> {});  // Hier een lege lambda
        return http.build();
    }
}
