package com.example.demo.serviceImplementation;

import java.util.List;

import com.example.demo.entity.bug;
import com.example.demo.repository.bugRepository;
import com.example.demo.service.bugService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugServiceImplementation implements bugService{

	@Autowired
	private bugRepository bugRepository;

	@Override
	public bug saveAllBug(bug bug) {
		// TODO Auto-generated method stub
		return bugRepository.save(bug);
	}

	@Override
	public List<bug> getAllBug() {
		// TODO Auto-generated method stub
		return bugRepository.findAll();
	}

	@Override
	public bug getBugById(int id) {
		// TODO Auto-generated method stub
		return bugRepository.findById(id).get();
	}

	@Override
	public bug updateBug(bug bug) {
		// TODO Auto-generated method stub
		return bugRepository.save(bug);
	}

	@Override
	public void deleteBugById(int id) {
		// TODO Auto-generated method stub
		bugRepository.deleteById(id);
	}

	
	 
	
	
	
	
}
