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
 * @version 0.1.0
 */
@Entity
public class team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	@Column(unique = true)
	private String tname;
	
	private String trole;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER,mappedBy = "team")
	private List<user> user=new ArrayList<user>();

	
	@ManyToMany(mappedBy = "team")
	private List<project> projects=new ArrayList<project>();


	

	/***/
	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public String getTrole() {
		return trole;
	}


	public void setTrole(String trole) {
		this.trole = trole;
	}


	public List<user> getUser() {
		return user;
	}


	public void setUser(List<user> user) {
		this.user = user;
	}


	public List<project> getProjects() {
		return projects;
	}


	public void setProjects(List<project> projects) {
		this.projects = projects;
	}


	@Override
	public String toString() {
		return "team [tid=" + tid + ", tname=" + tname + ", trole=" + trole + ", user=" + user + ", projects="
				+ projects + "]";
	}


	

	public team() {
		super();
		//TODO Auto-generated constructor stub
	}

	
}
