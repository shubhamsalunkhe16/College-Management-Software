package com.POJO.basics;

public class Library {
	private int stdid;
	private String stdname;
	private String book;
	private String idate;
	private String rdate;
	
	
	public Library(int stdid, String stdname, String book, String idate, String rdate) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.book = book;
		this.idate = idate;
		this.rdate = rdate;
	}
	
	
	public Library() {
		// TODO Auto-generated constructor stub
	}


	

	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
	@Override
	public String toString() {
		return "Library [stdid=" + stdid + ", stdname=" + stdname + ", book=" + book + ", idate=" + idate + ", rdate="
				+ rdate + "]";
	}
	
	

}
