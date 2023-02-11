package com.mercury.SprintBootRestSchedulingApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SprintBootRestSchedulingApp.http.Response;
import com.mercury.SprintBootRestSchedulingApp.service.AuthService;


@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/checklogin")
	public Response checklogin(Authentication authentication) {
		return authService.checklogin(authentication);
	}
}
