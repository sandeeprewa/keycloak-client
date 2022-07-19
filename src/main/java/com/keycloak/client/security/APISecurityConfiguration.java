package com.keycloak.client.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

//@Configuration
//@Slf4j
//@EnableWebSecurity
public class APISecurityConfiguration {

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * log.debug("SecurityFilterChain filterChain {}", http);
	 * 
	 * http.authorizeHttpRequests( (authz) -> authz.antMatchers("/**") .permitAll()
	 * //.antMatchers("/private/**") //.authenticated() //.antMatchers("/ignore/**")
	 * //.authenticated()
	 * 
	 * ) .httpBasic();
	 * 
	 * return http.build(); }
	 * 
	 * @Bean public WebSecurityCustomizer webSecurityCustomizer() {
	 * log.debug("Inside webSecurityCustomizer"); return (web) ->
	 * web.ignoring().antMatchers("/ignore/*"); }
	 */
}
