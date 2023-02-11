package com.mercury.SprintBootRestSchedulingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SprintBootRestSchedulingApp.bean.Timeoffrequests;
import com.mercury.SprintBootRestSchedulingApp.http.Response;
import com.mercury.SprintBootRestSchedulingApp.service.TimeoffrequestsService;

@RestController
@RequestMapping("/timeoffrequests")
public class TimeoffrequestsController {
	
	@Autowired
	private TimeoffrequestsService timeoffrequestsService;
	
	@GetMapping
	public List<Timeoffrequests> getAll(){
		return timeoffrequestsService.getAll();
	}
	
	@GetMapping("/uid/{uid}")
	public List<Timeoffrequests> getByUid(@PathVariable Integer uid){
		return timeoffrequestsService.getTimeoffrequestsByUid(uid);
	}

	@GetMapping("/{status}")
	public List<Timeoffrequests> getByStatus(@PathVariable String status){
		return timeoffrequestsService.getTimeoffrequestsByStatus(status);
	}
	
	@GetMapping("/id/{id}")
	public Timeoffrequests getById(@PathVariable Integer id){
		return timeoffrequestsService.getById(id);
	}
	
	@PostMapping
	public Response save(@RequestBody Timeoffrequests timeoffrequests) {
		return timeoffrequestsService.save(timeoffrequests);
	}
	
	@PutMapping
	public Response updateTimeoffrequests(@RequestBody Timeoffrequests timeoffrequests) {
		return timeoffrequestsService.updateTimeoffrequests(timeoffrequests);
	}
	
	@DeleteMapping("/{id}")
	public Response deleteTimeoffrequests(@PathVariable int id) {
		return timeoffrequestsService.deleteTimeoffrequests(id);
	}
}
