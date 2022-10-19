package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 * @author Shubham.Varneshiya
 * @version 0.1
 */

@Entity
public class project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(unique = true)
	private String project_name;
	private String technology;
	private String status;
	private boolean isdelete;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<team> team=new ArrayList<team>();

	
	
	/*****************/	
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isIsdelete() {
		return isdelete;
	}

	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}

	public List<team> getTeam() {
		return team;
	}

	public void setTeam(List<team> team) {
		this.team = team;
	}

	
	
	/************/
	
	
	
	
	/*****************/
	
	public project(int pid, String project_name, String technology, String status, boolean isdelete,
			List<com.example.demo.entity.team> team) {
		super();
		this.pid = pid;
		this.project_name = project_name;
		this.technology = technology;
		this.status = status;
		this.isdelete = isdelete;
		this.team = team;
	}

	

	@Override
	public String toString() {
		return "project [pid=" + pid + ", project_name=" + project_name + ", technology=" + technology + ", status="
				+ status + ", isdelete=" + isdelete + ", team=" + team + "]";
	}

	public project() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
