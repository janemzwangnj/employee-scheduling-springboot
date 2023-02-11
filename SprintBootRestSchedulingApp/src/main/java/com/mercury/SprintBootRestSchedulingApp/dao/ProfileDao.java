package com.mercury.SprintBootRestSchedulingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{

}
