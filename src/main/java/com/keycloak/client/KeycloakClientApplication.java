package com.keycloak.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class KeycloakClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakClientApplication.class, args);
	}

}
