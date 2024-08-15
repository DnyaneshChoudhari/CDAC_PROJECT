package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtRequestFilter;

	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()
		// Disable CSRF entirely
		).authorizeHttpRequests(
				authorize -> authorize.requestMatchers("/api/products", "/v*/api-doc*/**", "/swagger-ui/**").permitAll()
						.requestMatchers("/authenticate", "/register", "/admin").permitAll()
						.requestMatchers("/api/payments/create-order","/api/payments/success").permitAll()
						 .requestMatchers("/api/deliveries/**","/api/orders/**").hasAnyRole("ADMIN", "DELIVERY")
				            // Allow access to delivery-related APIs only to ADMIN and DELIVERY_PERSON roles
						// Allow public access to these endpoints

						.anyRequest().authenticated() // All other endpoints require authentication
		).exceptionHandling(exception -> exception.authenticationEntryPoint(customAuthenticationEntryPoint)
		// Handle unauthorized access

		).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		// No session management (JWT)

		);

		// Add JWT token filter before the default UsernamePasswordAuthenticationFilter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
