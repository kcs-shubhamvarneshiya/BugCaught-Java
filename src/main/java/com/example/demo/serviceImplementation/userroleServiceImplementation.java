package com.example.demo.serviceImplementation;

import java.util.List;

import com.example.demo.entity.userRole;
import com.example.demo.repository.userRoleRepository;
import com.example.demo.service.userRoleService;

import org.springframework.stereotype.Service;



/***
 * @author Shubham.Varneshiya
 */

@Service
public class userroleServiceImplementation implements userRoleService{

	private userRoleRepository repository;
	
	
	public userroleServiceImplementation(userRoleRepository repository) {
		super();
		this.repository=repository;
		//TODO Auto-generated constructor stub
	}


	@Override
	public userRole getUserroleById(int user_role_id) {
		// TODO Auto-generated method stub
		return repository.findById(user_role_id).get();
	}

	@Override
	public List<userRole> getAllrole() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public void deleteById(int user_role_id) {
		repository.deleteById(user_role_id);
		
	}

	

}
