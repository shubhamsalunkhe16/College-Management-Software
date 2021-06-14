package com.POJO.basics;

public class Marks {
	private int stid;
	private String stname;
	private int phy;
	private int chem;
	private int bio;
	
	
	@Override
	public String toString() {
		return  stid + "/t" + stname + "\t" + phy + "\t" + chem + "\t" + bio;
	}
	
	
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
	public int getPhy() {
		return phy;
	}
	public void setPhy(int phy) {
		this.phy = phy;
	}
	public int getChem() {
		return chem;
	}
	public void setChem(int chem) {
		this.chem = chem;
	}
	public int getBio() {
		return bio;
	}
	public void setBio(int bio) {
		this.bio = bio;
	}
	public Marks(int stid, String stname, int phy, int chem, int bio) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.phy = phy;
		this.chem = chem;
		this.bio = bio;
	}


	public Marks() {
		// TODO Auto-generated constructor stub
	}


	
	
}
