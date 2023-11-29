package com.padhu.rest.webservices.restfulwebservice.security;


import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//all request should be authenticated
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		// if a request not authenticated, web page is shown
		http.httpBasic(withDefaults());
		
		//CSRf -> POST,put
		http.csrf().disable();
		
		return http.build();
	}
}
