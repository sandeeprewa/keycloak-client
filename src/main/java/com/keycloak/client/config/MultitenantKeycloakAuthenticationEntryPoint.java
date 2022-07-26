package com.keycloak.client.config;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;
import com.keycloak.client.entrypoint.util.RequestInputExtractor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultitenantKeycloakAuthenticationEntryPoint extends KeycloakAuthenticationEntryPoint {

	public MultitenantKeycloakAuthenticationEntryPoint(AdapterDeploymentContext adapterDeploymentContext) {
        super(adapterDeploymentContext);
    }

    public MultitenantKeycloakAuthenticationEntryPoint(AdapterDeploymentContext adapterDeploymentContext, RequestMatcher apiRequestMatcher) {
        super(adapterDeploymentContext, apiRequestMatcher);
    }

    @Override
    protected void commenceLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	log.debug(" Inside commenceLoginRedirect Request URI {}", request.getRequestURI());

    	String tenant = RequestInputExtractor.resolveTenantByQueryParamOrByContextOrDefault(request);
        
        String contextAwareLoginUri = request.getContextPath() + "/tenant" + DEFAULT_LOGIN_URI +"?tenant="+ tenant;
        
        log.debug(" RequestURL {} Redirect URI {}", request.getRequestURL(), contextAwareLoginUri);
        response.sendRedirect(contextAwareLoginUri);
    }


}