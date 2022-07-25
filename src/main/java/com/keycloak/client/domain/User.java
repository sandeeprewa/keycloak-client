package com.keycloak.client.domain;

import java.util.Map;
import java.util.Set;

import org.keycloak.representations.AccessToken;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {

	private static final String INCENTMAX = "incentmax";

	private String userName;
	private String fName;
	private String lName;
	private String email;
	private String employeeCode;
	private String tenantId;
	private Set<String> roles;
	private Map<String, Object> claims;
	private String timeStamp;
	private String callbackURL;
	private String accessToken;
	private String customerIdentifier;
	private String orgName;
	private String atmaxProductUriToRedirect;

	public static User buildUser(AccessToken accessToken) {
		return User.builder()
				.userName(accessToken.getPreferredUsername())
				.email(accessToken.getEmail())
				.fName(accessToken.getGivenName())
				.lName(accessToken.getMiddleName())
				.employeeCode(accessToken.getId())
				.roles(accessToken.getRealmAccess().getRoles())
				.tenantId(accessToken.getRealmAccess().toString())
				.claims(accessToken.getOtherClaims())
				.atmaxProductUriToRedirect(INCENTMAX)
				.build();
	}

}
