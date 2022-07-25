package com.keycloak.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.keycloak.client.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApiAtmaxProxyService {

	@Autowired
	private Environment env;
	
	/**
	 * Redirect URL : String
	 */
	public String loginAndGetRedirectUrl(User user) {
		return callSSO(user);
	}

	private String callSSO(User dto) {
		log.info("Inside call sso User ===> {}", dto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Accept", "application/json");
		HttpEntity<User> entity = new HttpEntity<>(dto, headers);
		RestTemplate rt = new RestTemplate();
		
		log.info("Calling api_atmax with url: {}" ,env.getProperty("sso.path"));
			
		ResponseEntity<String> rs = rt.postForEntity( env.getProperty("sso.path"), entity, String.class);
		
		log.info("POST: calling sso.path= /api/auth/sso/integeration url {}",env.getProperty("sso.path"));

		String url = rs.getBody();
		
		log.info(" =====>url {}", url);
		return url;
	   }
}
