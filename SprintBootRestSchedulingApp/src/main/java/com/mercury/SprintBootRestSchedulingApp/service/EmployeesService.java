package com.mercury.SprintBootRestSchedulingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.bean.Employees;
import com.mercury.SprintBootRestSchedulingApp.dao.EmployeesDao;

@Service
public class EmployeesService {

	@Autowired
	private EmployeesDao employeesDao;
	
	public Employees getEmployeesByEid(String eid){
		return employeesDao.findByEid(eid);
	}
	
	public Employees getEmployeesByUid(Integer uid){
		return employeesDao.findByUid(uid);
	}
	
	public List<Employees> getEmployees(){
		return employeesDao.findAll();
	}
}
