package com.POJO.basics;

public class Teacher {
	private int tid;
	private String tname;
	private String tcontact;
	private String temail;
	private String tqualification;
	
	
	public Teacher(int tid, String tname, String tcontact, String temail, String tqualification) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tcontact = tcontact;
		this.temail = temail;
		this.tqualification = tqualification;
	
	}
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return tid+"\t"+ tname +"\t"+tcontact+"\t"+temail+"\t"+tqualification ;
	}

	
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
	public String getTcontact() {
		return tcontact;
	}
	public void setTcontact(String tcontact) {
		this.tcontact = tcontact;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public String getTqualification() {
		return tqualification;
	}
	public void setTqualification(String tqualification) {
		this.tqualification = tqualification;
	}

}
