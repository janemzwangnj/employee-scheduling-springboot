package com.mercury.SprintBootRestSchedulingApp.http;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;

public class AuthenticationSuccessResponse extends Response {

	private Users user;

	public AuthenticationSuccessResponse(boolean success, int code, String message, Users user) {
		super(success, code, message);
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
