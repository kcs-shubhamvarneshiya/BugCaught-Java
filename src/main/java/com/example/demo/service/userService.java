package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.user;

/**
 * 
 * @author Shubham.Varneshiya
 * @version 1.0
 * 
 */

public interface userService {

	
	user saveUser(user user);
	
	user getUserByuemail(String uemail);
	
	List<user> getAllUser();
	
	user getUserByuid(int uid);
	
	public void deleteUserById(int uid);
	
	user updateUser(user user);
	
}
