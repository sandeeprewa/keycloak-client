package com.keycloak.client.config;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.adapters.AdapterDeploymentContext;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.keycloak.client.common.ConfigConstant;
import com.keycloak.client.common.Validator;

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

    	String tenant = resolveTenantByQueryParamOrByContextOrDefault(request);
        
        String contextAwareLoginUri = request.getContextPath() + "/tenant" + DEFAULT_LOGIN_URI +"?tenant="+ tenant;
        
        log.debug(" RequestURL {} Redirect URI {}", request.getRequestURL(), contextAwareLoginUri);
        response.sendRedirect(contextAwareLoginUri);
    }

	private String resolveTenantByQueryParamOrByContextOrDefault(HttpServletRequest request) {
		String tenant = request.getParameter(ConfigConstant.TENANT_QUERY_PARAM);
		
		if(! Validator.isEmpty(tenant)) {
			return tenant;
		}
		
		tenant = resolveTenantFromContextPath(request.getContextPath());
		
		if(!Validator.isEmpty(tenant)) {
			return tenant;
		}
		
		return ConfigConstant.DEFAULT_TENANT;
	}

	private String resolveTenantFromContextPath(String contextPath) {
		if(!Validator.isEmpty(contextPath)) {
			 String splitedDomain[] = contextPath.split("\\.");
			 if(Objects.nonNull(splitedDomain) && splitedDomain.length !=0) {
				 return splitedDomain[0];
			 }
		}
		return ConfigConstant.EMPTY;
	}

}