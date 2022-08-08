package com.mercury.SprintBootRestSchedulingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.Dao.UsersDao;
import com.mercury.SprintBootRestSchedulingApp.bean.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	public Users getById(int id) {
		return usersDao.findById(id).get();
	}

}
