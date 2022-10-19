package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.entity.team;
import com.example.demo.entity.user;
import com.example.demo.entity.userRole;

import com.example.demo.repository.userRepository;
import com.example.demo.service.teamService;
import com.example.demo.service.userRoleService;
import com.example.demo.service.userService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * @author Shubham.Varneshiya {@summary <i>controller Details</i>}
 */
@Controller
public class teamController {

	/**************************/
	@Autowired
	private teamService service;

	@Autowired
	private userService userService;

	@Autowired
	private userRepository repository2;

	@Autowired
	private userRoleService roleService;

	/*************************/

	/*** Routing Start *******/

	/**
	 * 
	 * @param model
	 * @param request
	 * @return {}
	 */
	@RequestMapping("/team")
	public String teamCall(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			List<team> tData = service.getAllTeams();

			if (tData.isEmpty()) {
				model.addAttribute("teamList", null);
				return "Admin/team";
			} else {
				model.addAttribute("teamList", service.getAllTeams());
				return "Admin/team";
			}
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}

	}

	/***
	 * 
	 * @param team
	 * @return {@summary insert team data into database}
	 */

	@RequestMapping("/addTeam")
	public String teamAddCall(team team, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			try
			{
				service.saveAllTeam(team);
				return "redirect:/team";
			}
			catch(Exception e)
			{
				model.addAttribute("ErrMsg", "Team Name Is Already Exist !!");
				return "redirect:/team";
			}
			
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	/* Add Member into teams (form) */
	@RequestMapping("/addMember")
	public String addMemberCall(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			model.addAttribute("roleList", roleService.getAllrole());
			model.addAttribute("userData", userService.getAllUser());
			model.addAttribute("role", "Select Role");
			model.addAttribute("teamList", service.getAllTeams());
			return "Admin/addMember";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	@RequestMapping("/search")
	public String searchCall(@RequestParam("rid") int id, Model model) {
		userRole role = roleService.getUserroleById(id);
		List<user> userData = repository2.findAllByRole(role);

		model.addAttribute("teamList", service.getAllTeams());
		model.addAttribute("roleList", roleService.getAllrole());
		model.addAttribute("role", role.getUser_role());
		model.addAttribute("userData", userData);
		return "Admin/addMember";
	}

	/***
	 * 
	 * @param tid     To get parameter value from jsp page
	 * @param model   to pass object & value to jsp page
	 * @param request object of {@link HttpServletRequest}
	 * @return team page with added member into team {@summary "Add member into
	 *         teams (logic)"}
	 * 
	 */
	@RequestMapping("/addDev")
	public String insertDev(@RequestParam("tid") int tid, Model model, HttpServletRequest request, user user) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			team team = service.getTeamById(tid);
			String teamName = team.getTname().toString();
			System.out.println("team Name is : " + teamName);

			String[] id = request.getParameterValues("uid");
			Integer[] values = Arrays.stream(id).map(Integer::parseInt).toArray(Integer[]::new);

			for (int i = 0; i < values.length; i++) {

				user = userService.getUserByuid(values[i]);

				user.getTeam().add(team);
				team.getUser().add(user);

				service.saveAllTeam(team);
				userService.saveUser(user);

			}

			return "redirect:/team";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}

	}

	/****
	 * 
	 * @param tid
	 * @param model
	 * @return list of users
	 */
	@RequestMapping(value = "teamShow/{tid}", method = RequestMethod.GET)
	public String teamShowCall(@PathVariable int tid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			team team = service.getTeamById(tid);
			// List<user> user=userService.getAllUser();
			List<user> existingUser = repository2.findAllByTeam(team);

			model.addAttribute("teamData", team);
			model.addAttribute("userData", existingUser);

			return "/Admin/showMember";

		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	@RequestMapping(value = "addMoreMember/{tid}", method = RequestMethod.GET)
	public String addMoreMem(HttpServletRequest request, @PathVariable("tid") int tid, Model model) {
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			team team = service.getTeamById(tid);

			String teamRole = team.getTrole();

			List<user> list = new ArrayList<user>();

			List<user> user1 = userService.getAllUser();
			List<user> existUser = repository2.findAllByTeam(team);

			for (int i = 0; i < existUser.size(); i++) {
				user uid = existUser.get(i);
				user1.remove(uid);

			}

			for (user user : user1) {

				userRole role = user.getRole();
				String userrole = role.getUser_role();

				if (userrole.equals(teamRole)) {
					list.add(user);

				}
			}

			model.addAttribute("teamName", team);
			model.addAttribute("roleList", roleService.getAllrole());
			model.addAttribute("userList", list);
			model.addAttribute("Selectedrole", "Select Your Role");

			return "/Admin/addMore";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	@RequestMapping("/searchDev")
	public String searchDevCall(@RequestParam("rid") int rid, @RequestParam("tid") int tid, Model model) {

		userRole role = roleService.getUserroleById(rid);
		List<userRole> roleList = roleService.getAllrole();

		team team = service.getTeamById(tid);
		List<user> allUsers = repository2.findAllByRole(role);

		List<user> existingUsers = repository2.findAllByTeam(team);

		for (int i = 0; i < existingUsers.size(); i++) {
			user uid = existingUsers.get(i);
			allUsers.remove(uid);
		}

		model.addAttribute("teamName", team);
		model.addAttribute("roleList", roleList);
		model.addAttribute("userList", allUsers);
		model.addAttribute("Selectedrole", role.getUser_role());

		return "Admin/addMore";
	}

	@RequestMapping("/addMore")
	public String addMoreCall(HttpServletRequest request, @RequestParam("tid") int tid, Model model, user user) {
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			team team = service.getTeamById(tid);
			String[] id = request.getParameterValues("uid");

			Integer[] values = Arrays.stream(id).map(Integer::parseInt).toArray(Integer[]::new);

			for (int i = 0; i < values.length; i++) {

				user = userService.getUserByuid(values[i]);

				user.getTeam().add(team);
				team.getUser().add(user);

				service.saveAllTeam(team);
				userService.saveUser(user);

			}

			return "redirect:/team";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}

	}

	/***
	 * 
	 * @param uid   To find user by its id
	 * @param tid   To find team by its id
	 * @param model To pass object to another JSP page
	 * @param user  user entity object
	 * @param team  team entity object
	 * @return user list {@summary This method will remove user from the particular
	 *         team by id }
	 */
	@RequestMapping(value = "removeDev/{uid}/{tid}", method = RequestMethod.GET)
	public String removeDeveloperCall(@PathVariable("uid") int uid, @PathVariable("tid") int tid, Model model,
			user user, team team, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			user = userService.getUserByuid(uid);
			team = service.getTeamById(tid);

			user.getTeam().remove(team);
			team.getUser().remove(user);

			userService.saveUser(user);
			service.saveAllTeam(team);

			return "redirect:/teamShow/{tid}";

		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	/* Routing End */

}
