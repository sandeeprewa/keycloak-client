package com.keycloak.client;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import com.keycloak.client.config.AtmaxKeycloakResolver;
import com.keycloak.client.config.KeycloakCustomConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(KeycloakCustomConfiguration.class)
public class KeycloakClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakClientApplication.class, args);
	}
	

}
