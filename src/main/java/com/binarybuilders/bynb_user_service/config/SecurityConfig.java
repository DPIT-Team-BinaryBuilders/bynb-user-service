package com.binarybuilders.bynb_user_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< Updated upstream
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
=======

import org.springframework.security.authentication.AuthenticationProvider;
>>>>>>> Stashed changes
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
<<<<<<< Updated upstream

=======
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
>>>>>>> Stashed changes
import static org.springframework.security.config.Customizer.withDefaults;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

<<<<<<< Updated upstream
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                            auth.requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                                    .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                                    .anyRequest().authenticated();
                        }// All other endpoints require authentication
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );


        return http.build();
    }
=======

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
>>>>>>> Stashed changes


<<<<<<< Updated upstream
=======

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable).sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                   .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeHttpRequests((authorize) -> {
                        authorize.requestMatchers("/auth/**").permitAll();
                        authorize.requestMatchers("/error").permitAll();
                        authorize.anyRequest().authenticated();
                    }).httpBasic(withDefaults());


        return http.build();
    }





>>>>>>> Stashed changes
}
