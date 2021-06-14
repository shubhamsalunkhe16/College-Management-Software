package com.POJO.basics;

public class Attendance {
	
	private int stid;
	private String stname;
	private String attendance;
	
	
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	
	@Override
	public String toString() {
		return "Attendance [stid=" + stid + ", stname=" + stname + ", attendance=" + attendance + "]";
	}
	
	
	public Attendance(int stid, String stname, String attendance) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.attendance = attendance;
	}
	
	public Attendance() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
	
}
