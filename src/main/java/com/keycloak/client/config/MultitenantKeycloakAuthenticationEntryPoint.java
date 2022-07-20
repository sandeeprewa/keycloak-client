package com.keycloak.client.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

//@Component
public class MultitenantKeycloakAuthenticationEntryPoint extends KeycloakAuthenticationEntryPoint {

    public MultitenantKeycloakAuthenticationEntryPoint(AdapterDeploymentContext adapterDeploymentContext) {
        super(adapterDeploymentContext);
    }

    public MultitenantKeycloakAuthenticationEntryPoint(AdapterDeploymentContext adapterDeploymentContext, RequestMatcher apiRequestMatcher) {
        super(adapterDeploymentContext, apiRequestMatcher);
    }

    @Override
    protected void commenceLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getRequestURI();
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println(path);
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");

        String tenant = "default";
        
        if(null !=path && path.contains("private")) {
        	tenant = "private";
        }
        
        if(null !=path && path.contains("protected")) {
        	tenant = "protected";
        }
        
        System.out.println(path);

        System.out.println(tenant);

        String contextAwareLoginUri = request.getContextPath() + "/tenant/" + tenant + DEFAULT_LOGIN_URI;
        response.sendRedirect(contextAwareLoginUri);
    }
}