package com.example.demo.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.entity.bug;
import com.example.demo.entity.project;
import com.example.demo.entity.team;
import com.example.demo.entity.user;
import com.example.demo.repository.teamRepository;
import com.example.demo.repository.userRepository;
import com.example.demo.service.bugService;
import com.example.demo.service.projectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shubham.Varneshiya
 */
@Controller
public class BugController {

	@Autowired
	private projectService projectService;

	@Autowired
	private teamRepository repository;

	@Autowired
	private userRepository userRepository;

	@Autowired
	private bugService bugService;

	@RequestMapping(value = "raiseBug/{pid}", method = RequestMethod.GET)
	public String raiseBug(@PathVariable("pid") int id, Model model, project project, HttpServletRequest request) {

		HttpSession session = request.getSession();
		user userSess = (user) session.getAttribute("TesterSess");

		project projectData = projectService.getProjectById(id);

		List<team> teamData = repository.findAllByProjects(projectData);

		List<user> userData = new ArrayList<user>();

		for (int i = 0; i < teamData.size(); i++) {

			team teamId = teamData.get(i);
			List<user> teamUser = userRepository.findAllByTeam(teamId);

			for (user user : teamUser) {
				if (user.getRole().getUser_role().equals("Developer")) {
					userData.add(user);
				} else {
					continue;
				}

			}

		}

		model.addAttribute("projectData", projectData);
		model.addAttribute("userList", userData);
		model.addAttribute("tester", userSess);
		return "/tester/bug";
	}

	@RequestMapping("/addBug")
	public String assignBug(bug bug, Model model) {
		user developer = bug.getDid();
		developer.getBug().add(bug);
		bugService.saveAllBug(bug);
		userRepository.save(developer);

		return "redirect:/qaDash";
	}

	@RequestMapping("/bugList")
	public String bugList(Model model) {

		List<bug> bugData = bugService.getAllBug();

		model.addAttribute("bugData", bugData);
		return "Admin/bugList";
	}

	/* Developer */
	@RequestMapping(value = "fixBug/{bid}", method = RequestMethod.GET)
	public String bugReply(@PathVariable("bid") int bid, Model model) {

		bug bugData = bugService.getBugById(bid);

		model.addAttribute("bugList", bugData);

		return "/user/replyBug";
	}

	@RequestMapping("/editStatus")
	public String editStatus(Model model, bug bug, @RequestParam("bid") int id) {
		bug existBug = bugService.getBugById(id);

		existBug.setBid(id);
		existBug.setBdes(bug.getBdes());
		existBug.setBstatus(bug.getBstatus());
		existBug.setDid(bug.getDid());
		existBug.setPid(bug.getPid());
		existBug.setTid(bug.getTid());

		bugService.updateBug(existBug);

		return "redirect:/devDash";
	}

	/* Tester */
	@RequestMapping(value = "replyBug/{bid}", method = RequestMethod.GET)
	public String bugReplyTest(@PathVariable("bid") int id, Model model) {
		bug existBug = bugService.getBugById(id);
		model.addAttribute("BugData", existBug);
		return "/tester/replyBug";
	}

	@RequestMapping("/ansReply")
	public String editStatusTest(Model model, bug bug, @RequestParam("bid") int id) {
		bug existBug = bugService.getBugById(id);

		existBug.setBid(id);
		existBug.setBdes(bug.getBdes());
		existBug.setBstatus(bug.getBstatus());
		existBug.setDid(bug.getDid());
		existBug.setPid(bug.getPid());
		existBug.setTid(bug.getTid());

		bugService.updateBug(existBug);
		return "redirect:/qaDash";
	}
	/**/

	@RequestMapping(value = "DeleteBug/{bid}", method = RequestMethod.GET)
	public String deleteBug(@PathVariable("bid") int id, Model model) {
		bugService.deleteBugById(id);
		return "redirect:/devDash";
	}

	@RequestMapping("/exportPdf")
	public String exportToPdf() {
		return "Admin/ReportPdf";
	}
}
