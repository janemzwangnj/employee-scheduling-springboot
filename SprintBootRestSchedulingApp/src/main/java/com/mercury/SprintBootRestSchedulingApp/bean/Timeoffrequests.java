package com.mercury.SprintBootRestSchedulingApp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIMEOFFREQUESTS")
public class Timeoffrequests {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String start;
	
	@Column
	private String endd;
	
	@Column
	private String reason;
	
	@Column
	private String status;
	
	@Column
	private int uid;
	
	
	public Timeoffrequests() {
		super();
	}


	public Timeoffrequests(int id, String start, String endd, String reason, String status, int uid) {
		super();
		this.id = id;
		this.start = start;
		this.endd = endd;
		this.reason = reason;
		this.status = status;
		this.uid = uid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEndd() {
		return endd;
	}


	public void setEndd(String endd) {
		this.endd = endd;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	@Override
	public String toString() {
		return "Timeoffrequests [id=" + id + ", start=" + start + ", endd=" + endd + ", reason=" + reason + ", status="
				+ status + ", uid=" + uid + "]";
	}

}
