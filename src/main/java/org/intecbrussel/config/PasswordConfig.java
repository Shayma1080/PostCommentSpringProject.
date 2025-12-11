package org.intecbrussel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // versleutelt wachtwoorden veilig
    }

    // BCrypt voegt auto salt toe, waardoor password moeilijk te kraken zijn
    // Salt = Xy7!(willekeurig) -- > een random stuk data toevoegen
    // Hash = hash(passqord123 + Xy7!)
}
