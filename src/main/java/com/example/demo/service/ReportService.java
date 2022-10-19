package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.report;

public interface ReportService {

	report saveReport(report report);
	
	List<report> findAllReport();
	
	report getReportById(int id);
}
