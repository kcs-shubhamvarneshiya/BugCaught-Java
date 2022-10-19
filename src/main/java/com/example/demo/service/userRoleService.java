package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.userRole;



public interface userRoleService {

	List<userRole> getAllrole();
	
	userRole getUserroleById(int user_role_id );
	
	public void deleteById(int user_role_id);
	
	
	
}
