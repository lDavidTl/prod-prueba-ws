package com.producto.prd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	private final AuthenticationConfiguration configuration;
	
	public SecurityConfig(AuthenticationConfiguration configuration) {
		this.configuration = configuration;
	}
}