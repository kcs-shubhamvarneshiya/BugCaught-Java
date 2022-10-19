package com.example.demo.serviceImplementation;

import java.util.List;

import com.example.demo.entity.user;
import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/***
 * 
 * @author Shubham.Varneshiya
 * @version 1.0
 * 
 */

@Service
public class userServiceImplementation implements userService
{

	@Autowired
	private userRepository repository;
	
	
	
	public userServiceImplementation(userRepository repository) {
		super();
		this.repository=repository;
		//TODO Auto-generated constructor stub
	}



	@Override
	public user saveUser(user user) 
	{
		return repository.save(user);
	}



	@Override
	public user getUserByuemail(String uemail) {
		// TODO Auto-generated method stub
		return repository.getUserByuemail(uemail);
	}



	@Override
	public List<user> getAllUser() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}



	@Override
	public user getUserByuid(int uid) {
		// TODO Auto-generated method stub
		return repository.findById(uid).get();
	}



	@Override
	public void deleteUserById(int uid) {
		repository.deleteById(uid);	
	}



	@Override
	public user updateUser(user user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}
	

}
