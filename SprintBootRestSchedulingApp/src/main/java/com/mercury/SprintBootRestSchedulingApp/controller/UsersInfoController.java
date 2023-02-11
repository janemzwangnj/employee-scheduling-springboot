package com.mercury.SprintBootRestSchedulingApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SprintBootRestSchedulingApp.bean.UsersInfo;
import com.mercury.SprintBootRestSchedulingApp.http.Response;
import com.mercury.SprintBootRestSchedulingApp.service.UsersInfoService;

@RestController
@RequestMapping("/users_info")
public class UsersInfoController {
	
	@Autowired
	private UsersInfoService usersInfoService;
	
	@GetMapping("/{id}")
	public Optional<UsersInfo> getUserDetail(@PathVariable int id) {
		return usersInfoService.getById(id);
	}

	@GetMapping()
	public List<UsersInfo> getAll() {
		return usersInfoService.getAll();
	}
	
	@PostMapping
	public Response postUserDetails(@RequestBody UsersInfo usersInfo, Authentication authentication) {
		return usersInfoService.addUserInfo(usersInfo, authentication);
	}
	
	@PutMapping
	public Response putUserInfos(@RequestBody UsersInfo userInfo) {
		return usersInfoService.updateUserInfo(userInfo);
	}
	
}
