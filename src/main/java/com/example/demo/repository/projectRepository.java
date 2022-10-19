package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.project;
import com.example.demo.entity.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepository extends JpaRepository<project, Integer>{

	List<project> findAllByTeam(team team);
	
	
}
