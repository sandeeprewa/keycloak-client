package com.keycloak.client.domain;

import java.util.Map;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

	private String userName;
	private String fName;
	private String lName;
	private String email;
	private String employeeID;
	private String tenantId;
	private Set<String> roles;
	private Map<String, Object> claims;
}
