package com.keycloak.client.entrypoint.util;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class KeycloakUtil {

	@SuppressWarnings("rawtypes")
	public AccessToken loggedInAccessToken() {
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) token.getPrincipal();
		KeycloakSecurityContext session = keycloakPrincipal.getKeycloakSecurityContext();
		return session.getToken();
	}

}
