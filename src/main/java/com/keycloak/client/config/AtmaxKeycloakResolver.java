package com.keycloak.client.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AtmaxKeycloakResolver implements KeycloakConfigResolver{

    private KeycloakDeployment keycloakDeployment;

  //  @Autowired(required=false)
    private AdapterConfig adapterConfig =null;

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
    
    	log.debug("***************AtmaxKeycloakResolver ****Resolve *****");
    	if (keycloakDeployment != null) {
            return keycloakDeployment;
        }

        keycloakDeployment = KeycloakDeploymentBuilder.build(adapterConfig);
        return keycloakDeployment;
    }

}
