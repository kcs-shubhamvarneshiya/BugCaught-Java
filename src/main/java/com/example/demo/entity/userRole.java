package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Shubham.Varneshiya
 * @version 0.1.0
 */

@Entity
public class userRole {
	
	/* Fields */
	
	@Id
	private int user_role_id;
	@Column(unique = true)
	private String user_role;
	

	public userRole() {
		super();
		//TODO Auto-generated constructor stub
	}



	public userRole(int user_role_id, String user_role) {
		super();
		this.user_role_id = user_role_id;
		this.user_role = user_role;
	}



	/* Getter Setter Methods of Above Fields */
	
	public int getUser_role_id() {
		return user_role_id;
	}



	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}



	public String getUser_role() {
		return user_role;
	}



	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}



	@Override
	public String toString() {
		return "userRole [user_role_id=" + user_role_id + ", user_role=" + user_role + "]";
	}
	
	
	
	
	
	

}
