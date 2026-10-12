package com.example.intelliflow.config;
import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@Profile("!dev")
@EnableMethodSecurity
public class ProductionSecurityConfig {
  @Bean SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(csrf -> csrf.disable())
      .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(a -> a.requestMatchers("/actuator/health/**").permitAll()
        .requestMatchers("/api/v1/**").authenticated().anyRequest().denyAll())
      .oauth2ResourceServer(o -> o.jwt(Customizer.withDefaults())).build();
  }
}
