package com.mercury.SprintBootRestSchedulingApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {

}
