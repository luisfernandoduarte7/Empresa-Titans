package com.empresa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http)throws Exception {
        http
        .csrf().disable()
        .authorizeHttpRequests((requests)-> requests
                
                .requestMatchers(
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui/index.html")
                .permitAll()
                
                .requestMatchers(
                HttpMethod.POST,"/equipe/", "/produto/")
                .authenticated()
                
                .requestMatchers(
                        HttpMethod.GET,"/equipe/", "/produto/")
                        .permitAll()
                .requestMatchers(
                        HttpMethod.DELETE,"/equipe/{id}", "/produto/{id}")
                .authenticated()
                
                .requestMatchers(
                        HttpMethod.PUT,"/equipe/{id}", "/produto/{id}")
                .authenticated()
                
                .anyRequest()
                .denyAll()
                )
        
        .httpBasic();
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsSevice() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Tech Titans")
                .password("SHILD")
                .roles("USER")
                .build();
                return new InMemoryUserDetailsManager(user);
    }
}
