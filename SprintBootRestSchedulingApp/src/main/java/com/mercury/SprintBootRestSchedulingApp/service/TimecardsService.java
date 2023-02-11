package com.mercury.SprintBootRestSchedulingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SprintBootRestSchedulingApp.bean.Timecards;
import com.mercury.SprintBootRestSchedulingApp.dao.TimecardsDao;
import com.mercury.SprintBootRestSchedulingApp.http.Response;

@Service
public class TimecardsService {
	
	@Autowired
	private TimecardsDao timecardsDao;
	
	public List<Timecards> getAll(){
		return timecardsDao.findAll();
	}

	public List<Timecards> getTimecardsById(String eid){
		return timecardsDao.findByEid(eid);
	}
	
	public Response save(Timecards timecards) {
		timecardsDao.save(timecards);
		return new Response(true);
	}
	
	public Response updateTimecards(Timecards timecards) {
		List<Timecards> list = timecardsDao.findByEid(timecards.getEid());
		Timecards newTC = list.get(0);
		for(Timecards tc : list) {
			if(tc.getId() > newTC.getId()) {
				newTC = tc;
			}
		}
		newTC.setEnd_time(timecards.getEnd_time());
		timecardsDao.save(newTC);
		return new Response(true);
	}

	public Response deleteTimecards(int id) {
		if(timecardsDao.findById(id).get() != null) {
			timecardsDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "Timecard is not found!");
		}
	}
}
