package com.keycloak.client.entrypoint;

import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessToken.Access;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class KeyCloakSSOEntrypoint {

	@GetMapping("/public/test")
	public String publicTest(HttpServletRequest request) {
		return "public Resource";
	}

	@GetMapping("/private/test")
	public String privateTest(HttpServletRequest request) {

		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();

		KeycloakPrincipal principal11 = (KeycloakPrincipal) token.getPrincipal();

		KeycloakSecurityContext session = principal11.getKeycloakSecurityContext();
		AccessToken accessToken = session.getToken();
		String username = accessToken.getPreferredUsername();
		String emailID = accessToken.getEmail();
		String lastname = accessToken.getFamilyName();
		String firstname = accessToken.getGivenName();
		String realmName = accessToken.getIssuer();
		Access realmAccess = accessToken.getRealmAccess();
		java.util.Set<String> roles = realmAccess.getRoles();

		System.out.println(username);
		System.out.println(emailID);
		System.out.println(lastname);
		System.out.println(firstname);
		System.out.println(realmName);
		System.out.println(roles);
		return "private Resource ==> UserName ==>" + username + "-==>EmailID ==>" + emailID + "===lastName==>"
				+ lastname + "=====fName==>" + firstname + "====realmName==>" + realmName + "====roles==>" + roles;
	}

	@GetMapping("/protected/test")
	public String private1Test(HttpServletRequest request) {

		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();

		KeycloakPrincipal principal11 = (KeycloakPrincipal) token.getPrincipal();

		KeycloakSecurityContext session = principal11.getKeycloakSecurityContext();
		AccessToken accessToken = session.getToken();
		String username = accessToken.getPreferredUsername();
		String emailID = accessToken.getEmail();
		String lastname = accessToken.getFamilyName();
		String firstname = accessToken.getGivenName();
		String realmName = accessToken.getIssuer();
		Access realmAccess = accessToken.getRealmAccess();
		java.util.Set<String> roles = realmAccess.getRoles();

		System.out.println(username);
		System.out.println(emailID);
		System.out.println(lastname);
		System.out.println(firstname);
		System.out.println(realmName);
		System.out.println(roles);
		return "private Resource ==> UserName ==>" + username + "-==>EmailID ==>" + emailID + "===lastName==>"
				+ lastname + "=====fName==>" + firstname + "====realmName==>" + realmName + "====roles==>" + roles;
	}

	
	@GetMapping("/ignore/test")
	public String ignore() {
		return "ignore Resource";
	}

}
