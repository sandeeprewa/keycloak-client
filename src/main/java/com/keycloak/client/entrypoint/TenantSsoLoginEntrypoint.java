package com.keycloak.client.entrypoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantSsoLoginEntrypoint {

	@GetMapping("/public/test")
	public String publicTest() {
		return "public Resource";
	}
	
	@GetMapping("/private/test")
	public String privateTest() {
		return "private Resource";
	}

	@GetMapping("/ignore/test")
	public String ignore() {
		return "ignore Resource";
	}

}
