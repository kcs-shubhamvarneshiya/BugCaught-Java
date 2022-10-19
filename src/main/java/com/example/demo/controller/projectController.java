	package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.entity.project;
import com.example.demo.entity.team;
import com.example.demo.repository.teamRepository;
import com.example.demo.service.projectService;
import com.example.demo.service.teamService;


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
 * @since
 */

@Controller
public class projectController {

	@Autowired
	private projectService service;

	@Autowired
	private teamService teamService;

	@Autowired
	private teamRepository repository;
	
	/**************************/

	/**
	 * @return - project JSP page
	 */
	@RequestMapping("/project")
	public String projectHome(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			model.addAttribute("errorMsg", null);
			return "Admin/project";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login Please ! ");
			return "user/login";
		}
	}

	@RequestMapping("/addProject")
	public String addProjectCall(Model model, project project) {
		try {
			service.saveProject(project);
			return "redirect:/projectList";
		} catch (Exception e) {
			model.addAttribute("errorMsg", "Project Already Exist ");
			return "Admin/project";
		}

	}

	@RequestMapping("/projectList")
	public String projectListShow(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			model.addAttribute("projectList", service.getAllProject());
			return "Admin/projectList";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login Please ! ");
			return "user/login";
		}
	}

	@RequestMapping("/projectAssign")
	public String assignProject(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String adminSess = (String) session.getAttribute("AdminSess");

		if (adminSess != null) {
			model.addAttribute("teamList", teamService.getAllTeams());
			model.addAttribute("projectList", service.getAllProject());
			return "Admin/assignPro";
		} else {
			model.addAttribute("ErrMsg", "Please Do Login Please ! ");
			return "user/login";
		}
	}

	@RequestMapping("/assignTo")
	public String assignToCall(@RequestParam("pid") int id, Model model, HttpServletRequest request, team team) {

		project project = service.getProjectById(id);

		String[] tid = request.getParameterValues("tid");
		Integer[] values = Arrays.stream(tid).map(Integer::parseInt).toArray(Integer[]::new);

		for (int i = 0; i < values.length; i++) {

			team = teamService.getTeamById(values[i]);

			team.getProjects().add(project);
			project.getTeam().add(team);

			service.saveProject(project);
			teamService.saveAllTeam(team);
		}

		return "Admin/index";
	}

	@RequestMapping(value = "showTeamByProject/{pid}", method = RequestMethod.GET)
	public String getTeams(@PathVariable("pid") int pid, Model model) {

		project project = service.getProjectById(pid);
		List<team> teams = repository.findAllByProjects(project);

		model.addAttribute("projectList", project);
		model.addAttribute("teamList", teams);

		return "/Admin/showTeam";
	}

	@RequestMapping(value = "editTeamByProject/{pid}",method = RequestMethod.GET)
	public String projectTeam(@PathVariable("pid") int id,Model model,project project)
	{
		project=service.getProjectById(id);
		model.addAttribute("projectList", project);
		return "/Admin/editProject";
	}
	
	@RequestMapping("/EditProjectData")
	public String EditProjectData(@ModelAttribute("project") project project,@RequestParam("pid")String id,Model model)
	{
		System.out.println("im in");
		int pid=Integer.parseInt(id);
		project existProject=service.getProjectById(pid);
		existProject.setPid(pid);
		existProject.setProject_name(project.getProject_name());
		existProject.setTechnology(project.getTechnology());
		existProject.setStatus(project.getStatus());
		existProject.setIsdelete(false);
		
		service.updateProject(existProject);
		
		return "redirect:/projectList";
	}
	
	
	@RequestMapping(value = "DeleteTeamByProject/{pid}",method = RequestMethod.GET)
	public String deleteProject(@PathVariable("pid")int id,project project)
	{
		project project2=service.getProjectById(id);
		List<team> teamList=repository.findAllByProjects(project2);
		
		for (team team : teamList) {
			project2.getTeam().remove(team);
			team.getProjects().remove(project2);
		}
		
		service.deleteProjectById(id);
		return "redirect:/projectList";
	}
	
	@RequestMapping(value = "removeTeam/{tid}/{pid}", method = RequestMethod.GET)
	public String removeTeam(Model model, @PathVariable("tid") int tid, @PathVariable("pid") int pid, team team,
			project projects) {

		team = teamService.getTeamById(tid);
		projects = service.getProjectById(pid);

		team.getProjects().remove(projects);
		projects.getTeam().remove(team);

		teamService.saveAllTeam(team);
		service.saveProject(projects);

		return "redirect:/showTeamByProject/{pid}";
	}

	@RequestMapping(value = "addMoreTeam/{pid}", method = RequestMethod.GET)
	public String addMoreTeam(@PathVariable("pid") int pid, Model model, team team, project project) {
		project = service.getProjectById(pid);
		List<team> existTeams = repository.findAllByProjects(project);
		List<team> allTeams = teamService.getAllTeams();

		for (int i = 0; i < existTeams.size(); i++) {

			team tid = existTeams.get(i);
			allTeams.remove(tid);

		}
		
		model.addAttribute("teamsData", allTeams);
		model.addAttribute("projectData",project);
		
		return "/Admin/addMoreTeam";
	}
	
	@RequestMapping("/addMoreTeams")
	public String addMoreTeams(@RequestParam("pid") String pid,Model model,HttpServletRequest request,team team)
	{
		System.out.println("Im in");
		int id=Integer.parseInt(pid);
		project project = service.getProjectById(id);
//
		String[] tid = request.getParameterValues("tid");
		Integer[] values = Arrays.stream(tid).map(Integer::parseInt).toArray(Integer[]::new);
//
//		System.out.println();
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);

			team = teamService.getTeamById(values[i]);

			team.getProjects().add(project);
			project.getTeam().add(team);

			service.saveProject(project);
			teamService.saveAllTeam(team);
		}

		return "redirect:/projectList";
	}
	
	@RequestMapping(value = "editProject/{pid}",method = RequestMethod.GET)
	public String projectEdit(@PathVariable("pid") int id,Model model,project project)
	{
		project=service.getProjectById(id);
		model.addAttribute("projectList", project);
		return "/tester/editProject";
	}
	
	@RequestMapping("/editProStatus")
	public String updateProjectStatus(@RequestParam("pid")int id,project project,Model model)
	{
		project existProject=service.getProjectById(id);
		
		existProject.setPid(id);
		existProject.setProject_name(project.getProject_name());
		existProject.setStatus(project.getStatus());
		existProject.setIsdelete(false);
		existProject.setTechnology(project.getTechnology());
		
		service.updateProject(existProject);
		
		return "redirect:/qaDash";
	}

}
