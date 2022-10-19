package com.example.demo.controller;

import com.example.demo.service.userRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * @author Shubham.Varneshiya
 * @version 1.0
 */
public class userroleController {

	@Autowired
	private userRoleService roleService;

	
	/* Role delete with id */
	@RequestMapping(value = "userRoleDelete/{user_role_id}", method = RequestMethod.GET)
	public String roleDeleteCall(@PathVariable int user_role_id, Model model) {
		System.out.println("Role Delete");
		roleService.deleteById(user_role_id);
		return "redirect:/admdash";
	}
}
