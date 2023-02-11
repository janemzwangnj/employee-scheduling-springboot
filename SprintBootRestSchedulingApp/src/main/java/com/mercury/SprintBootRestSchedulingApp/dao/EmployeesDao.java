package com.mercury.SprintBootRestSchedulingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SprintBootRestSchedulingApp.bean.Employees;

public interface EmployeesDao extends JpaRepository<Employees,Integer> {
	Employees findByEid(String eid);
	Employees findByUid(Integer uid);
}
