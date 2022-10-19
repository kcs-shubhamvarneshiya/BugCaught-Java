package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.bug;

public interface bugService {

	bug saveAllBug(bug bug);
	
	List<bug> getAllBug();
	
	bug getBugById(int id);
	
	bug updateBug(bug bug);
	
	public void deleteBugById(int id);
	
}
