package com.keycloak.client.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakCustomConfiguration {

	@Bean("keycloakConfigResolver")
//    @ConditionalOnMissingBean(AtmaxKeycloakResolver.class)
	public KeycloakConfigResolver keycloakConfigResolver() {
	  return new AtmaxKeycloakResolver();			  
    }

}
