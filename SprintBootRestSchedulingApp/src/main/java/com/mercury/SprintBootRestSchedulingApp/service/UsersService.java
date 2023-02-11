package com.mercury.SprintBootRestSchedulingApp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.bean.Profile;
import com.mercury.SprintBootRestSchedulingApp.bean.Users;
import com.mercury.SprintBootRestSchedulingApp.dao.UsersDao;
import com.mercury.SprintBootRestSchedulingApp.http.Response;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Users getById(int id) {
		return usersDao.findById(id).get();
	}
	
	public List<Users> getAll() {
		return usersDao.findAll();
	}
	
	public Response register(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		List<Profile> profiles = new ArrayList<Profile>();
		
		profiles.add(new Profile(1));
		user.setProfiles(profiles);
		
		usersDao.save(user);
		
		return new Response(true);
	}
	
	public Response changePassword(Users user, Authentication authentication) {
		if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
			Users u = usersDao.findByUsername(user.getUsername());
			u.setPassword(passwordEncoder.encode(user.getPassword()));
			usersDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
	}
	
	public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
		boolean isAdmin = false;
		for(GrantedAuthority profle: profiles) {
			if(profle.getAuthority().equals("ADMIN")) {
				isAdmin = true;
			}
		};
		return isAdmin;
	}
	
	public Response deleteUser(int id) {
		if(usersDao.findById(id).get() != null) {
			usersDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}
}
