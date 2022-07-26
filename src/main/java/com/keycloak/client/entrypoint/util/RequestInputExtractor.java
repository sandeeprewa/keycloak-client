package com.keycloak.client.entrypoint.util;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.keycloak.client.common.ConfigConstant;
import com.keycloak.client.common.Validator;

public class RequestInputExtractor {

	public static String resolveTenantByQueryParamOrByContextOrDefault(HttpServletRequest request) {
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

	private static String resolveTenantFromContextPath(String contextPath) {
		if(!Validator.isEmpty(contextPath)) {
			 String splitedDomain[] = contextPath.split("\\.");
			 if(Objects.nonNull(splitedDomain) && splitedDomain.length !=0) {
				 String[] splitedSubDomain = splitedDomain[0].split("-");
				 return splitedSubDomain[0];

			 }
		}
		return ConfigConstant.EMPTY;
	}

}
