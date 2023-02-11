package com.mercury.SprintBootRestSchedulingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.bean.Timeoffrequests;
import com.mercury.SprintBootRestSchedulingApp.dao.TimeoffrequestsDao;
import com.mercury.SprintBootRestSchedulingApp.http.Response;

@Service
public class TimeoffrequestsService {
	
	@Autowired
	private TimeoffrequestsDao timeoffrequestsDao;
	
	public List<Timeoffrequests> getAll(){
		return timeoffrequestsDao.findAll();
	}
	
	public List<Timeoffrequests> getTimeoffrequestsByUid(Integer uid){
		return timeoffrequestsDao.findByUid(uid);
	}
	
	public Timeoffrequests getById(Integer id){
		return timeoffrequestsDao.findById(id).get();
	}
	
	public List<Timeoffrequests> getTimeoffrequestsByStatus(String status){
		return timeoffrequestsDao.findByStatus(status);
	}


	public Response save(Timeoffrequests timeoffrequests) {
		timeoffrequestsDao.save(timeoffrequests);
		return new Response(true);
	}
	
	public Response updateTimeoffrequests(Timeoffrequests timeoffrequests) {
		Timeoffrequests newTR = (Timeoffrequests) timeoffrequestsDao.findById(timeoffrequests.getId()).get();
		newTR.setStatus(timeoffrequests.getStatus());
		timeoffrequestsDao.save(newTR);
		return new Response(true);
	}
	
	public Response deleteTimeoffrequests(int id) {
		if(timeoffrequestsDao.findById(id).get() != null) {
			timeoffrequestsDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "Timeoffrequest is not found!");
		}
	}
}
