package com.mercury.SprintBootRestSchedulingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;
import com.mercury.SprintBootRestSchedulingApp.http.Response;
import com.mercury.SprintBootRestSchedulingApp.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/{id}")
	public Users getById(@PathVariable int id) {
		return usersService.getById(id);
	}
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public List<Users> getAll() {
		return usersService.getAll();
	}
	
	
	@PostMapping
	public Response addUser(@RequestBody Users user) {
		return usersService.register(user);
	}
	
	//@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@PutMapping
	public Response changeUser(@RequestBody Users user, Authentication authentication) {
		return usersService.changePassword(user, authentication);
	}
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return usersService.deleteUser(id);
	}
}
