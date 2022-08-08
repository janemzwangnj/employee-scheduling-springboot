package com.mercury.SprintBootRestSchedulingApp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity	
@Table(name="USERS")
public class Users {
	
	@Id	
	@SequenceGenerator(name = "users_seq_gen", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(generator="users_seq_gen", strategy = GenerationType.AUTO)
	private int user_id; // above 2 gen annotations only work while inserting data into table
	
	@Column
	private String username;
	
	@Column
	private int password;	
	
	public Users() {
		super();
	};

	public Users(int user_id, String username, int password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}

}
