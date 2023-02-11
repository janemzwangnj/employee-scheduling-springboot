package com.mercury.SprintBootRestSchedulingApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.Timeoffrequests;

public interface TimeoffrequestsDao extends JpaRepository<Timeoffrequests,Integer> {
	List<Timeoffrequests> findByUid(Integer uid);
	List<Timeoffrequests> findByStatus(String status);
}
