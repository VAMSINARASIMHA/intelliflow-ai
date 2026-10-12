package com.example.intelliflow.config;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@Profile("dev")
public class DevSecurityConfig {
  @Bean SecurityFilterChain devFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).build();
  }
}
