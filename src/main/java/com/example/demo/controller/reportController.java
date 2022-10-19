package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.PdfExportor.ProjectReportPdfExport;
import com.example.demo.entity.project;
import com.example.demo.entity.report;
import com.example.demo.service.ReportService;
import com.example.demo.service.projectService;
import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class reportController {

	@Autowired
	private projectService service;

	@Autowired
	private ReportService reportService;

	@RequestMapping(value = "projectReport/{pid}", method = RequestMethod.GET)
	public String projectTeam(@PathVariable("pid") int id, Model model, project project) {
		project = service.getProjectById(id);
		model.addAttribute("projectData", project);
		return "/Admin/report";
	}

	@RequestMapping("/generateReport")
	public String generateReport(report report, Model model, project project) {
		try {
			reportService.saveReport(report);
			return "redirect:/admdash";
		} catch (Exception e) {
			int pid = report.getPid().getPid();
			project = service.getProjectById(pid);
			model.addAttribute("projectData", project);
			model.addAttribute("errMsg", "You can't generate report twice for same project");
			return "Admin/report";
		}

	}

	@RequestMapping("/displayReport")
	public String displayReport(Model model) {
		List<report> reportList = reportService.findAllReport();
		model.addAttribute("reportData", reportList);
		return "Admin/reportList";
	}

	@RequestMapping(value = "/exportPdf/{rid}",method = RequestMethod.GET)
	public void exportReportPdf(@PathVariable("rid") int id,HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
//		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		String currentDateTime = dateFormatter.format(new Date());
		
		report reportData=reportService.getReportById(id);
		
		String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=BugCaught_" + reportData.getPid().getProject_name() + ".pdf";
        response.setHeader(headerKey, headerValue);
        
        ProjectReportPdfExport export=new ProjectReportPdfExport(reportData);
        export.export(response);
        
	}

}
