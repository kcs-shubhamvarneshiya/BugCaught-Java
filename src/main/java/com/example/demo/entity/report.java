package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;

	@OneToOne
	private project pid;

	private String status;
	private String startdate;
	private String enddate;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public project getPid() {
		return pid;
	}

	public void setPid(project pid) {
		this.pid = pid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "report [rid=" + rid + ", pid=" + pid +  ", status=" + status + ", startdate="
				+ startdate + ", enddate=" + enddate + "]";
	}

	public report(int rid, project pid, team tid, String status, String startdate, String enddate) {
		super();
		this.rid = rid;
		this.pid = pid;

		this.status = status;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public report() {
		super();
		// TODO Auto-generated constructor stub
	}

}
