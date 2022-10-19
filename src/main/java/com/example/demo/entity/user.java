package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class user {
	
	/* Fields */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String ufname;
	private String ulname;
	@Column(unique = true)
	private String uemail;
	private String upassword;
	
	@OneToOne(fetch = FetchType.EAGER)
	private userRole role;

	@OneToMany
	private List<bug> bug=new ArrayList<bug>();
	
	@ManyToMany
	private List<team> team=new ArrayList<team>();

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUfname() {
		return ufname;
	}

	public void setUfname(String ufname) {
		this.ufname = ufname;
	}

	public String getUlname() {
		return ulname;
	}

	public void setUlname(String ulname) {
		this.ulname = ulname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public userRole getRole() {
		return role;
	}

	public void setRole(userRole role) {
		this.role = role;
	}

	public List<bug> getBug() {
		return bug;
	}

	public void setBug(List<bug> bug) {
		this.bug = bug;
	}

	public List<team> getTeam() {
		return team;
	}

	public void setTeam(List<team> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "user [uid=" + uid + ", ufname=" + ufname + ", ulname=" + ulname + ", uemail=" + uemail + ", upassword="
				+ upassword + ", role=" + role + ", bug=" + bug + ", team=" + team + "]";
	}

	public user(int uid, String ufname, String ulname, String uemail, String upassword, userRole role,
			List<com.example.demo.entity.bug> bug, List<com.example.demo.entity.team> team) {
		super();
		this.uid = uid;
		this.ufname = ufname;
		this.ulname = ulname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.role = role;
		this.bug = bug;
		this.team = team;
	}

	public user() {
		super();
		//TODO Auto-generated constructor stub
	}


	/* Getter And Setter Methods of above Fields */
	
	
	
}
