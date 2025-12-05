package org.intecbrussel.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyUserDetailsService  {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withUsername("Chaima")
                .password("{noop}password123") // noop= geen encryptie, alleen voor testen
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
