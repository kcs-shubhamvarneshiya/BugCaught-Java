package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.entity.bug;
import com.example.demo.entity.project;
import com.example.demo.entity.team;
import com.example.demo.entity.user;
import com.example.demo.entity.userRole;
import com.example.demo.mailService.mailSenderService;
import com.example.demo.repository.bugRepository;
import com.example.demo.repository.projectRepository;
import com.example.demo.repository.teamRepository;
import com.example.demo.service.bugService;
import com.example.demo.service.teamService;
import com.example.demo.service.userRoleService;
import com.example.demo.service.userService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * @author Shubham.Varneshiya
 * @version 0.1.0
 **/

@Controller
public class userController {

	@Autowired
	private userService service;

	@Autowired
	private userRoleService roleService;

	@Autowired
	private teamService teamService;

	@Autowired
	private teamRepository teamRepository;

	@Autowired
	private projectRepository projectRepository;

	@Autowired
	private mailSenderService mailSenderService;

	@Autowired
	private bugService bugService;

	@Autowired
	private bugRepository bugRepository;

	/* Routing Starts From Here */

	@RequestMapping("/")
	public String indexCall(Model model) {
		return "redirect:/login";
	}

	/* Developer Dash board */
	@RequestMapping("/home")
	public String homeCall() {
		return "user/index";
	}

	/* Admin Dash board */
	@RequestMapping("/admdash")
	public String adminDashboardCall(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");
		
		if (adminSess != null) {
			model.addAttribute("userList", service.getAllUser());
			model.addAttribute("roleList", roleService.getAllrole());
			return "Admin/index";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}

	}

	/***
	 * 
	 * @param model
	 * @return {@summary Developer Register Here with role}
	 */
	@RequestMapping("/register")
	public String registerCall(Model model) {
		// passing All user role from database and show it on developer register page
		model.addAttribute("userRoleData", roleService.getAllrole());
		return "Admin/register";
	}

	@RequestMapping("/login")
	public String loginCall(Model model) {
		try {

			String uData = service.getAllUser().toString();
			boolean present = uData.contains("Admin");

			String msg = "Welcom Back !";
			if (present == true) {
				model.addAttribute("ErrMsg", msg);
				return "user/login";

			} else {
				return "redirect:/register";
			}
		} catch (Exception exception) {
			return "redirect:/register";
		}

	}

	@SuppressWarnings("unused")
	@RequestMapping("/loginchk")
	public String loginCheck(@RequestParam("uemail") String email, @RequestParam("upassword") String password,
			Model model, HttpServletRequest request) {

		user user_Data = service.getUserByuemail(email);
		String role = user_Data.getRole().toString();

		/*
		 * if User Enter invalid email which is not present in database then i will
		 * throw custom error message on login page
		 */
		if (user_Data == null) {
			model.addAttribute("ErrMsg", "User Doesn't Exist");
			return "user/login";
		} else {

			/* If user's role is Admin */

			if (user_Data.getUemail().equals(email) && user_Data.getUpassword().equals(password)
					&& role.contains("Admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("AdminSess", user_Data.getUfname());
				// String sess=(String) session.getAttribute("AdminSess");
				return "redirect:/admdash";
			}
			/* If user's role is Developer */
			else if (user_Data.getUemail().equals(email) && user_Data.getUpassword().equals(password)
					&& role.contains("Developer")) {

				HttpSession session = request.getSession();
				session.setAttribute("DevSess", user_Data);
				return "redirect:/devDash";
			}
			/* If user's role is Tester */
			else if (user_Data.getUemail().equals(email) && user_Data.getUpassword().equals(password)
					&& role.contains("Tester")) {

				HttpSession session = request.getSession();
				session.setAttribute("TesterSess", user_Data);
				return "redirect:/qaDash";
			}
			/* If user enter invalid either password or email */
			else {
				model.addAttribute("ErrMsg", "Invalid Email Or Password");
				return "user/login";
			}
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "user/login";
	}

	/***
	 * 
	 * @param id
	 * @param user
	 * @param model
	 * @param role
	 * @param request
	 * @return {@summary During the registration developer will get mail on his
	 *         respective mail with credential i.e. email id and password.}
	 */
	@RequestMapping("/addUser")
	public String addUserCall(@RequestParam("user_role_id") int id, user user, Model model, userRole role,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			role.setUser_role_id(id);
			user.setRole(role);

			/* Email Parameter */

			String toEmail = user.getUemail();
			String password = user.getUpassword();
			String name = user.getUfname();
			String subject = "Credential";
			String msg = "Dear " + name + "," + System.lineSeparator() + "Your userId is " + toEmail
					+ " and Your Password is " + password + " for login purpose.";

			/******************/

			try {
				// save user and send mail

				service.saveUser(user);
				mailSenderService.sendSimpleMail(toEmail, msg, subject);
				model.addAttribute("AdminSess", name);
				return "redirect:/admdash";
			} catch (Exception err) {
				// If user enter existing mail id then it will throw an error on registration
				// page
				model.addAttribute("errMsg", "Something Went Wrong with Email id plz check");
				model.addAttribute("userRoleData", roleService.getAllrole());
				return "Admin/register";
			}

		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}

	}

	@RequestMapping("/useradd")
	public String userAddCall(Model model) {
		model.addAttribute("userRoleData", roleService.getAllrole());
		return "Admin/index";
	}

	/* Edit user's Data */
	@RequestMapping(value = "userEdit/{uid}", method = RequestMethod.GET)
	public String userUpdateCall(@PathVariable int uid, Model model, HttpServletRequest request) {

		user user = service.getUserByuid(uid);
		model.addAttribute("UserData", user);
		model.addAttribute("userRoleData", roleService.getAllrole());
		return "/Admin/userEditData";

	}

	/* */
	@RequestMapping("/EditUserData")
	public String userDetailsUpdate(@ModelAttribute("user") user user, @RequestParam("uid") int uid, Model model,
			@RequestParam("user_role_id") int role, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			userRole userRole = new userRole();
			userRole.setUser_role_id(role);
			user user2 = service.getUserByuid(uid);
			user2.setUid(uid);
			user2.setUfname(user.getUfname());
			user2.setUlname(user.getUlname());
			user2.setUemail(user.getUemail());
			user2.setUpassword(user2.getUpassword());
			user2.setRole(userRole);

			service.updateUser(user2);
			return "redirect:/admdash";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	/* User delete with id */
	@RequestMapping(value = "userDelete/{uid}", method = RequestMethod.GET)
	public String userDeleteCall(@PathVariable int uid, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {

			service.deleteUserById(uid);
			return "redirect:/admdash";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !");
			return "user/login";
		}
	}

	/* Developer Model Start */

	@SuppressWarnings("unused")
	@RequestMapping("/devDash")
	public String developerDesh(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("DevSess");

		if (user != null) {
			int id = user.getUid();

			List<team> teamData = teamRepository.findAllByUser(user);

			List<bug> bugData = bugRepository.findAllByDid(user);

			List<bug> openBugList = new ArrayList<bug>();

			for (bug bug : bugData) {

				int bid = bug.getBid();
				bug bugList = bugService.getBugById(bid);

				if (bugList.getBstatus().contains("Close") || bugList.getBstatus().contains("Fixed")) {
					continue;
				} else {

					openBugList.add(bug);
				}
			}

			model.addAttribute("teamList", teamData);
			model.addAttribute("bugData", openBugList);
			return "user/index";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !!");
			return "user/login";
		}

	}

	@RequestMapping(value = "searchProject/{tid}", method = RequestMethod.GET)
	public String displayProject(@PathVariable("tid") int id, Model model) {
		team team = teamService.getTeamById(id);
		List<project> projectData = projectRepository.findAllByTeam(team);
		model.addAttribute("projectList", projectData);
		return "/user/showProject";
	}

	/* Developer Model End */

	/* Tester Model Start */

	@RequestMapping("/qaDash")
	public String testerDash(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("TesterSess");

		if (user != null) {
			List<team> teamData = teamRepository.findAllByUser(user);

			List<bug> bugList = bugRepository.findAllByTid(user);

			List<bug> openBugList = new ArrayList<bug>();

			for (bug bug : bugList) {

				int bid = bug.getBid();
				bug bugData = bugService.getBugById(bid);

				if (bugData.getBstatus().contains("Close")) {
					continue;
				} else {

					openBugList.add(bug);
				}
			}

			model.addAttribute("BugData", openBugList);
			model.addAttribute("teamList", teamData);
			return "tester/index";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !!");
			return "user/login";
		}

	}

	@RequestMapping(value = "searchProject2/{tid}", method = RequestMethod.GET)
	public String displayProject2(@PathVariable("tid") int id, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		user user = (user) session.getAttribute("TesterSess");

		if (user != null) {
			team team = teamService.getTeamById(id);
			List<project> projectData = projectRepository.findAllByTeam(team);
			List<bug> bugList = bugRepository.findAllByTid(user);

			List<bug> bugStatus = new ArrayList<bug>();

			for (int i = 0; i < bugList.size(); i++) {

				bug bug = bugList.get(i);
				int bid = bug.getBid();
				bug bugData = bugService.getBugById(bid);

				if (bugData.getBstatus().contains("Close")) {
					continue;
				} else {
					bugStatus.add(bugData);

				}

			}

			if (bugStatus.isEmpty()) {
				System.out.println("Data nulllllll");
			} else {
				model.addAttribute("BugStatus", bugStatus);
			}
			model.addAttribute("projectList", projectData);
			model.addAttribute("teamData", team);

			return "/tester/showProject";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login First !!");
			return "user/login";
		}
	}

	/* Tester Model End */
}
