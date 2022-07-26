package com.keycloak.client.entrypoint;

import org.springframework.web.bind.annotation.RestController;

import com.keycloak.client.common.Validator;
import com.keycloak.client.domain.User;
import com.keycloak.client.entrypoint.util.KeycloakUtil;
import com.keycloak.client.entrypoint.util.RequestInputExtractor;
import com.keycloak.client.service.ApiAtmaxProxyService;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Slf4j
public class KeyCloakSSOEntrypoint {

	private KeycloakUtil keycloakUtil;
	private ApiAtmaxProxyService apiAtmaxProxyService;
	
	@Autowired
	public KeyCloakSSOEntrypoint(KeycloakUtil keycloakUtil,ApiAtmaxProxyService apiAtmaxProxyService ) {
		this.keycloakUtil = keycloakUtil;
		this.apiAtmaxProxyService = apiAtmaxProxyService;
	}
	
	@GetMapping(path = { "/api/v1/sso","api/auth/sso/integeration"})
	public void ssoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.debug("Inside ssoLogin {}", request.getRequestURL());
		
    	String tenant = RequestInputExtractor.resolveTenantByQueryParamOrByContextOrDefault(request);

		AccessToken accessToken = keycloakUtil.loggedInAccessToken();
		
		
		User user = User.buildUser(accessToken,tenant);
		
		
		log.debug("Retrived user is {}", user);
		String redirectUrl = apiAtmaxProxyService.loginAndGetRedirectUrl(user);
		log.debug("redirectURL is {}", redirectUrl);
		
		if(Validator.isEmpty(redirectUrl)) {
			throw new RuntimeException("Redirect URL is empty "+ redirectUrl);
		}
		response.sendRedirect(redirectUrl);
	}

}
