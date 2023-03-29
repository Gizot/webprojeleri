package com.gizo.security_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securtyfilterChain(HttpSecurity http) throws Exception {
		
		return http.authorizeRequests(authorizeConfig ->{
			authorizeConfig.antMatchers("/").permitAll();
			authorizeConfig.antMatchers("/error").permitAll();
			authorizeConfig.anyRequest().authenticated();
			
		})
				.formLogin(Customizer.withDefaults()) 
				//bu kısımdaki hatayı bulamadım :(!
				//.oauth2Login(Customizer.withDefaults())		
				.build();
	
	
	}
}
	
