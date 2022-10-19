package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

@Entity
public class bug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String bdes;
	
	@OneToOne(fetch = FetchType.EAGER)
	private project pid;

	private String bstatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private user did;
	
	@OneToOne(fetch = FetchType.EAGER)
	private user tid;

	/***/
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBdes() {
		return bdes;
	}

	public void setBdes(String bdes) {
		this.bdes = bdes;
	}

	public project getPid() {
		return pid;
	}

	public void setPid(project pid) {
		this.pid = pid;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public user getDid() {
		return did;
	}

	public void setDid(user did) {
		this.did = did;
	}

	public user getTid() {
		return tid;
	}

	public void setTid(user tid) {
		this.tid = tid;
	}

	

	public bug(int bid, String bdes, project pid, String bstatus, user did, user tid) {
		super();
		this.bid = bid;
		this.bdes = bdes;
		this.pid = pid;
		this.bstatus = bstatus;
		this.did = did;
		this.tid = tid;
	}

	public bug() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	
	
	

}
