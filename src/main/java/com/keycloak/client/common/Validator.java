package com.keycloak.client.common;

public class Validator {

	private Validator() {
		throw new IllegalStateException("Do not instantiate");
	}

	public static boolean isEmpty(String input) {
		return null == input || input.isBlank();
	}

}
