package com.mercury.SprintBootRestSchedulingApp.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIMECARDS")
public class Timecards {

	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String start_time;
	
	@Column
	private String end_time;
	
	@Column
	private String eid;
	
	public Timecards() {
		super();
	}

	public Timecards(int id, String start_time, String end_time, String eid) {
		super();
		this.id = id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.eid = eid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "Timecards [id=" + id + ", start_time=" + start_time + ", end_time=" + end_time + ", eid=" + eid + "]";
	}

}
