package org.intecbrussel.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyUserDetailsService  {

    private final PasswordEncoder passwordEncoder;

    public MyUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.builder()
                .username("Chaima")
                //.password("{noop}password123") // noop= geen encryptie, alleen voor testen
                .password(passwordEncoder.encode("password123")) // wachtwoord veilig gehashed
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
