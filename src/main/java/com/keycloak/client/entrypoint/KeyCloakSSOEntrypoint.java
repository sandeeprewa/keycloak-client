package com.keycloak.client.entrypoint;

import org.springframework.web.bind.annotation.RestController;
import com.keycloak.client.domain.User;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Slf4j
public class KeyCloakSSOEntrypoint {

	@GetMapping(path = { "/api/v1/sso","api/auth/sso/integeration"})
	public User ssoLogin(HttpServletRequest request) {
		log.debug("Inside ssoLogin {}", request.getRequestURL());
		AccessToken accessToken = loggedInAccessToken();
		return buildUser(accessToken);
	}

	private User buildUser(AccessToken accessToken) {
		return User.builder()
				.userName(accessToken.getPreferredUsername())
				.email(accessToken.getEmail())
				.fName(accessToken.getGivenName())
				.lName(accessToken.getMiddleName())
				.employeeID(accessToken.getId())
				.roles(accessToken.getRealmAccess().getRoles())
				.tenantId(accessToken.getRealmAccess().toString())
				.claims(accessToken.getOtherClaims())
				.build();
	}

	private AccessToken loggedInAccessToken() {
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		@SuppressWarnings("rawtypes")
		KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) token.getPrincipal();
		KeycloakSecurityContext session = keycloakPrincipal.getKeycloakSecurityContext();
		return session.getToken();
	}

}
