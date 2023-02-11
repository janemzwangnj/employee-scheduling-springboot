package com.mercury.SprintBootRestSchedulingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;


public interface UsersDao extends JpaRepository<Users,Integer> {
	Users findByUsername(String username);
}
