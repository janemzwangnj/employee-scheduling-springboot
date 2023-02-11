package com.mercury.SprintBootRestSchedulingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.dao.UsersDao;
import com.mercury.SprintBootRestSchedulingApp.http.AuthenticationSuccessResponse;
import com.mercury.SprintBootRestSchedulingApp.http.Response;

@Service
public class AuthService {
	
	@Autowired
	private UsersDao usersDao;

	public Response checklogin(Authentication authentication) {
		if (authentication != null) {
			Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", usersDao.findByUsername(authentication.getName()));
			return response;
		} else {
			return new Response(false);
		}
	}

}
