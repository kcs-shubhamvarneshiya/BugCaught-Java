package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.project;
import com.example.demo.entity.team;
import com.example.demo.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teamRepository extends JpaRepository<team, Integer>{

//	List<team> findAllByUser(user user);
//	
//	List<team> findAllByProjects(project project);
//	

	List<team> findAllByUser(user user);
	
	List<team> findAllByProjects(project project);

}
