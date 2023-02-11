package com.mercury.SprintBootRestSchedulingApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;
import com.mercury.SprintBootRestSchedulingApp.dao.UsersDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = usersDao.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + " does not exist!");
		};
		return user;
	}

}
