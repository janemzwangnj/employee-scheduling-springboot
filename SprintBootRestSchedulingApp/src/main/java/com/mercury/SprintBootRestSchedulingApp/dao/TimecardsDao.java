package com.mercury.SprintBootRestSchedulingApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.Timecards;

public interface TimecardsDao extends JpaRepository<Timecards,Integer> {
	List<Timecards> findByEid(String Eid);
}
