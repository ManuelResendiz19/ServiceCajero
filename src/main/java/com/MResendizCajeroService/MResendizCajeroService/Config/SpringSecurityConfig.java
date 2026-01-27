package com.MResendizCajeroService.MResendizCajeroService.Config;

import com.MResendizCajeroService.MResendizCajeroService.JWT.JwtAuthFilter;
import com.MResendizCajeroService.MResendizCajeroService.Service.UsuarioDetailsJPAService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final UsuarioDetailsJPAService usuarioDetailsJPAService;
    private final JwtAuthFilter jwtAuthFilter;

    public SpringSecurityConfig(UsuarioDetailsJPAService usuarioDetailsJPAService,
            JwtAuthFilter jwtAuthFilter) {
        this.usuarioDetailsJPAService = usuarioDetailsJPAService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {

        http.cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/cajero/loginCajero").permitAll()
                .requestMatchers("/api/Cajeros").permitAll()
                        .requestMatchers("/api/Cajeros/{IdCajero}").permitAll()
                .requestMatchers("/api/retirar").permitAll()
                .requestMatchers("/api/rellenar").permitAll()
                .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(usuarioDetailsJPAService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

}
