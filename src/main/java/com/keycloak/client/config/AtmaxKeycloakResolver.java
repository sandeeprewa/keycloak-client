package com.keycloak.client.config;

import java.io.InputStream;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.springframework.stereotype.Component;

import com.keycloak.client.common.ConfigConstant;
import com.keycloak.client.common.Validator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AtmaxKeycloakResolver implements KeycloakConfigResolver{

    private KeycloakDeployment keycloakDeployment;

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
    	String tenantName = tenantOrDefault(request);
    	String keycloakFile = tenantName + "-keycloak.json";
    	log.debug("Inside resolve tenant {} keycloakFile {}",tenantName,keycloakFile);

    	InputStream is =  getClass().getResourceAsStream("/"+keycloakFile);
        keycloakDeployment = KeycloakDeploymentBuilder.build(is);
        return keycloakDeployment;
    }

	private String tenantOrDefault(OIDCHttpFacade.Request requeset) {
		String tenant = requeset.getQueryParamValue(ConfigConstant.TENANT_QUERY_PARAM);
		
		if(Validator.isEmpty(tenant)) {
			tenant = ConfigConstant.DEFAULT_TENANT;
		}
		return tenant;
	}

}
