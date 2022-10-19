package com.example.demo.serviceImplementation;

import java.util.List;

import com.example.demo.entity.project;
import com.example.demo.repository.projectRepository;
import com.example.demo.service.projectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class projectServiceImplementation implements projectService{

	@Autowired
	private projectRepository repository;
	
	@Override
	public project saveProject(project project) {
		// TODO Auto-generated method stub
		return repository.save(project);
	}

	@Override
	public List<project> getAllProject() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public project getProjectById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public project updateProject(project project) {
		// TODO Auto-generated method stub
		return repository.save(project);
	}

	@Override
	public void deleteProjectById(int pid) {
		// TODO Auto-generated method stub
		repository.deleteById(pid);
	}

	
}
