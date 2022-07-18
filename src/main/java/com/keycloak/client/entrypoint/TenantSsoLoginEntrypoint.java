package com.keycloak.client.entrypoint;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantSsoLoginEntrypoint {
	
	
	@GetMapping("/public/test")
	public String publicTest(HttpServletRequest request) {
		
    final Principal principal = (Principal) request.getUserPrincipal();

    System.out.println("******** "+ principal);
	
		return "public Resource";
	}
	
	@GetMapping("/private/test")
	public String privateTest(HttpServletRequest request) {
	    final Principal principal = (Principal) request.getUserPrincipal();

	    System.out.println("******** "+ principal);

		
		return "private Resource";
	}

	@GetMapping("/ignore/test")
	public String ignore() {
		return "ignore Resource";
	}

}
