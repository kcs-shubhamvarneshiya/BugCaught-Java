package com.example.demo.serviceImplementation;

import java.util.List;

import com.example.demo.entity.report;
import com.example.demo.repository.ReportRepository;
import com.example.demo.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImplementation implements ReportService{

	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public report saveReport(report report) {
		// TODO Auto-generated method stub
		return reportRepository.save(report);
	}

	@Override
	public List<report> findAllReport() {
		// TODO Auto-generated method stub
		return reportRepository.findAll();
	}

	@Override
	public report getReportById(int id) {
		// TODO Auto-generated method stub
		return reportRepository.findById(id).get();
	}

}
