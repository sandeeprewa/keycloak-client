package com.keycloak.client.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RootExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		log.error("Exception ::: {}",e);
		return " <html><body> <H1>"
				+ ""
				+ "Some thing gone wrong"
				+ "</H1></body></html>";
	}
}
