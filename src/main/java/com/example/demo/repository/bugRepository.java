package com.example.demo.repository;





import java.util.List;

import com.example.demo.entity.bug;
import com.example.demo.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bugRepository extends JpaRepository<bug, Integer> {
	
	List<bug> findAllByDid(user user);
	
	List<bug> findAllByTid(user user);
	
}
