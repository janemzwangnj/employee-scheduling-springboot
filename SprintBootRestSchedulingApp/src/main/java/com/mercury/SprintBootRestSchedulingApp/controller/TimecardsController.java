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

import com.mercury.SprintBootRestSchedulingApp.bean.Timecards;
import com.mercury.SprintBootRestSchedulingApp.http.Response;
import com.mercury.SprintBootRestSchedulingApp.service.TimecardsService;

@RestController
@RequestMapping("/timecards")
public class TimecardsController {
	
	@Autowired
	private TimecardsService timecardsService;
	
	@GetMapping
	public List<Timecards> getAll(){
		return timecardsService.getAll();
	}
	
	@GetMapping("/{eid}")
	public List<Timecards> getById(@PathVariable String eid){
		return timecardsService.getTimecardsById(eid);
	}
	
	@PostMapping
	public Response save(@RequestBody Timecards timecards) {
		return timecardsService.save(timecards);
	}
	
	@PutMapping
	public Response updateTimecards(@RequestBody Timecards timecards) {
		return timecardsService.updateTimecards(timecards);
	}
	
	@DeleteMapping("/{id}")
	public Response deleteTimecards(@PathVariable int id) {
		return timecardsService.deleteTimecards(id);
	}

}
