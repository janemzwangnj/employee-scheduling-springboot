package com.mercury.SprintBootRestSchedulingApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			//.allowCredentials(true)	
			//.allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
			.allowedOrigins("http://localhost:4200")
			.allowedMethods("GET","POST","PUT","DELETE");
	}

}
