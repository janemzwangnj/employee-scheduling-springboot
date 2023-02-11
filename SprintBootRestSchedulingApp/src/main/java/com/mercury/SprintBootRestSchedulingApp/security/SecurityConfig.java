package com.mercury.SprintBootRestSchedulingApp.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.SprintBootRestSchedulingApp.security.handler.AccessDeniedHandlerImpl;
import com.mercury.SprintBootRestSchedulingApp.security.handler.AuthenticationEntryPointImpl;
import com.mercury.SprintBootRestSchedulingApp.security.handler.AuthenticationFailureHandlerImpl;
import com.mercury.SprintBootRestSchedulingApp.security.handler.AuthenticationSuccessHandlerImpl;
import com.mercury.SprintBootRestSchedulingApp.security.handler.LogoutSuccessHandlerImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPointImpl;
	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	@Autowired
	private UserDetailsService userDetailsServiceImpl;
	
  protected void configure(HttpSecurity http) throws Exception {
	  
	  http.csrf().disable();
	  http.cors();
	  
	  http.authorizeRequests(
			  (requests) -> requests
//			  					.antMatchers(HttpMethod.DELETE, "/users/*")
//			  						.hasAuthority("ADMIN")
//			  					.antMatchers(HttpMethod.POST, "/users")
//			  						.hasAuthority("ADMIN")
//			  					.antMatchers(HttpMethod.PUT, "/users")
//			  						.hasAnyAuthority("USER","ADMIN")
			  					.anyRequest()
			  						.permitAll()   
			  						//.authenticated()
			  );
	  
//	  http.exceptionHandling()
//	  	  .accessDeniedHandler(accessDeniedHandlerImpl)
//	  	  .authenticationEntryPoint(authenticationEntryPointImpl);
	  	
	  http.formLogin()
	  		.usernameParameter("username")
	  		.passwordParameter("password")
	  		.successHandler(authenticationSuccessHandlerImpl)
			.failureHandler(authenticationFailureHandlerImpl);
	  
	  http.logout()
		.permitAll()
		.logoutUrl("/logout")
		.logoutSuccessHandler(logoutSuccessHandlerImpl);
	  
	  http.httpBasic(); 
  }
  
	@Bean // put the return object into spring container, as a bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}
	
	@Autowired // @Autowired on function will be autowired the parameters
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder(11));
	}
	
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
        CorsConfiguration configuration = new CorsConfiguration();
       // configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Accept"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    } 

}
