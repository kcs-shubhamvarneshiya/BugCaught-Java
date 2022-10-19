package com.example.demo.serviceImplementation;

import java.util.List;

import com.example.demo.entity.team;
import com.example.demo.repository.teamRepository;
import com.example.demo.service.teamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class teamServiceImplementation implements teamService{

	@Autowired
	private teamRepository repository;

	@Override
	public team saveAllTeam(team team) {
		// TODO Auto-generated method stub
		return repository.save(team);
	}

	@Override
	public List<team> getAllTeams() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public team getTeamById(int tid) {
		// TODO Auto-generated method stub
		return repository.findById(tid).get();
	}
	
	


	

	

}
