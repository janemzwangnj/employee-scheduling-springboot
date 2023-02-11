package com.mercury.SprintBootRestSchedulingApp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.UsersInfo;

public interface UsersInfoDao extends JpaRepository<UsersInfo, Integer> {

	Optional<UsersInfo> findById(Integer id);
}
