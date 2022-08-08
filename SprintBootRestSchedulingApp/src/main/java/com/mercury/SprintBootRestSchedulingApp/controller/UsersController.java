package com.mercury.SprintBootRestSchedulingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;
import com.mercury.SprintBootRestSchedulingApp.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/{id}")
	public Users get(@PathVariable int id){
		return usersService.getById(id);
	}

}
