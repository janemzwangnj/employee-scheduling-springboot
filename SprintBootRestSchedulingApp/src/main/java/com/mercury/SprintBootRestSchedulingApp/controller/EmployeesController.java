package com.mercury.SprintBootRestSchedulingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SprintBootRestSchedulingApp.bean.Employees;
import com.mercury.SprintBootRestSchedulingApp.service.EmployeesService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@GetMapping("/{eid}")
	public Employees getEmployeesByEid(@PathVariable String eid){
		return employeesService.getEmployeesByEid(eid);
	}
	
	@GetMapping("/uid/{uid}")
	public Employees getEmployeesByUid(@PathVariable Integer uid){
		return employeesService.getEmployeesByUid(uid);
	}
	
	@GetMapping
	public List<Employees> getEmployees(){
		return employeesService.getEmployees();
	}

}
