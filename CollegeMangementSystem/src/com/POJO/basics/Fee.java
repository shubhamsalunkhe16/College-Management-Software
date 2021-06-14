package com.POJO.basics;

public class Fee {
	private int sid;
	private String sname;
	private String sfstatus;
	
	public Fee(int sid, String sname, String sfstatus) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sfstatus = sfstatus;
	}



	public Fee() {
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSfstatus() {
		return sfstatus;
	}

	public void setSfstatus(String sfstatus) {
		this.sfstatus = sfstatus;
	}
	
	public String toString() {
		return sid+"\t"+ sname +"\t"+sfstatus ;
	}
	
	
}
