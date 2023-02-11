package com.mercury.SprintBootRestSchedulingApp.http;

import com.mercury.SprintBootRestSchedulingApp.bean.UsersInfo;

public class UsersInfoResponse extends Response {

	private UsersInfo usersInfo;

	public UsersInfoResponse(boolean success, UsersInfo usersInfo) {
		super(success);
		this.usersInfo = usersInfo;
	}

	public UsersInfo getUsersInfo() {
		return usersInfo;
	}

	public void setUsersInfo(UsersInfo usersInfo) {
		this.usersInfo = usersInfo;
	}

}
