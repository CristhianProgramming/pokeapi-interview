package com.projectcrist.pokeapi.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.projectcrist.pokeapi.app.services.JpaAuthenticationLogin;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JpaAuthenticationLogin jpaAuthenticationManager;
	
	@Bean
 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http.authorizeHttpRequests().requestMatchers("/public/**").permitAll().anyRequest()
 				.hasRole("USER").and()
 				.formLogin() 
 				.permitAll();
 		return http.build();
 	}

	void jpaUsersAuthentication(AuthenticationManagerBuilder authorizations) throws Exception{
		authorizations.userDetailsService(jpaAuthenticationManager).passwordEncoder(encoder);
	}

	
	
}
