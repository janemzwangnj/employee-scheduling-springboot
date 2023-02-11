package com.mercury.SprintBootRestSchedulingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;
import com.mercury.SprintBootRestSchedulingApp.bean.UsersInfo;
import com.mercury.SprintBootRestSchedulingApp.dao.UsersDao;
import com.mercury.SprintBootRestSchedulingApp.dao.UsersInfoDao;
import com.mercury.SprintBootRestSchedulingApp.http.Response;
import com.mercury.SprintBootRestSchedulingApp.http.UsersInfoResponse;

@Service
public class UsersInfoService {

	@Autowired
	private UsersDao usersDao;
	
	Authentication authentication;
	
	@Autowired
	private UsersInfoDao usersInfoDao;
	
	public Response addUserInfo(UsersInfo usersInfo) {
		return new UsersInfoResponse(true, usersInfoDao.save(usersInfo));
	}
	
	public Response addUserInfo(UsersInfo usersInfo, Authentication authentication) {
		Users user = usersDao.findByUsername(authentication.getName());
		usersInfo.setUser(user);
		return new UsersInfoResponse(true, usersInfoDao.save(usersInfo));
	}
	
	public Response updateUserInfo(UsersInfo usersInfo) {
		UsersInfo ud = usersInfoDao.findById(usersInfo.getId()).get();
		usersInfo.setUser(ud.getUser());
		ud = usersInfo;
		usersInfoDao.save(ud);
		return new Response(true);
	}
	
	public Optional<UsersInfo> getById(Integer id){
		return usersInfoDao.findById(id);
	}

	public List<UsersInfo> getAll() {
		return usersInfoDao.findAll();
		}

//	public Optional<UsersInfo> getById(Integer id) {
//		Users u = usersDao.findByUsername(authentication.getName());
//		return usersInfoDao.findById(id);
//	}
	
}
