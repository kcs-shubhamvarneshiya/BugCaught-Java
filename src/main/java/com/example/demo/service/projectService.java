package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.project;


public interface projectService {

	project saveProject(project project);
	
	List<project> getAllProject();
	
	project getProjectById(int id);
	
	project updateProject(project project);
	
	public void deleteProjectById(int pid);
}
