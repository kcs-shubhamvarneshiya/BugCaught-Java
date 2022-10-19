package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.team;
import com.example.demo.entity.user;
import com.example.demo.entity.userRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/***
 * @author Shubham.Varneshiya
 * @version 1.0
 */


/**
 * {@summary JPARepository interface provides all CRUD related methods
 * Here i have extends that interface to invoke those methods.}
 */
@Repository
public interface userRepository extends JpaRepository<user, Integer>{

	user getUserByuemail(String uemail);
	
	List<user> findAllByTeam(team team);
	
	List<user> findAllByRole(userRole role);
	
	
	
	
}
