package com.keycloak.client.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.context.annotation.Bean;

@KeycloakConfiguration
public class KeycloakConfig {
	
	@Bean
	public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
	  return new KeycloakSpringBootConfigResolver();
			  
    }
	
}
