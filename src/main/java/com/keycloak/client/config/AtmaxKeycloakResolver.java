package com.keycloak.client.config;

import java.io.InputStream;

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
        	
    	InputStream is =  getClass().getResourceAsStream("/keycloak.json");
    	    	
    	if(request.getRelativePath().contains("private")) {
        	System.out.println("*************** PRIVIATE******* *****");
        	System.out.println("*************** PRIVIATE******* *****");
        	System.out.println("*************** PRIVIATE******* *****");
        	System.out.println("*************** PRIVIATE******* *****");
        	System.out.println("*************** PRIVIATE******* *****");
        	System.out.println("*************** PRIVIATE******* *****");

        	is = getClass().getResourceAsStream("/keycloak.json");
    	}
    	
    	if(request.getRelativePath().contains("protected")) {
        	System.out.println("*************** PROTECTED ******* *****");
        	System.out.println("*************** PROTECTED ******* *****");
        	System.out.println("*************** PROTECTED ******* *****");
        	System.out.println("*************** PROTECTED ******* *****");
        	System.out.println("*************** PROTECTED ******* *****");

        	is = getClass().getResourceAsStream("/keycloak1.json");
    	}
    	
        keycloakDeployment = KeycloakDeploymentBuilder.build(is);
        return keycloakDeployment;
    }

}
