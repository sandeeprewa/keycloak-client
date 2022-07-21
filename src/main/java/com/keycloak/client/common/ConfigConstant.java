package com.keycloak.client.common;

public class ConfigConstant {

	public static final String EMPTY = "";
	public static final String DEFAULT_TENANT = "default";
	public static final String TENANT_QUERY_PARAM = "tenant";

	private ConfigConstant() {
		throw new IllegalStateException("Do not instantiate");
	}
}
