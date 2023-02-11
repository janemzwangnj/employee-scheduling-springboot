package com.mercury.SprintBootRestSchedulingApp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String eid;
	
	@Column
	private int uid;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int id, String eid, int uid) {
		super();
		this.id = id;
		this.eid = eid;
		this.uid = uid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", eid=" + eid + ", uid=" + uid + "]";
	}

}
