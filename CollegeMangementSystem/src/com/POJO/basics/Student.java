package com.POJO.basics;

public class Student {
		private int sid;
		private String sname;
		private String scontact;
		private String semail;
		private String scourse;
		
		
		
		public String toString() {
			return sid+"\t"+ sname +"\t"+scontact+"\t"+semail+"\t"+scourse ;
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



		public String getScontact() {
			return scontact;
		}



		public void setScontact(String scontact) {
			this.scontact = scontact;
		}



		public String getSemail() {
			return semail;
		}



		public void setSemail(String semail) {
			this.semail = semail;
		}



		public String getScourse() {
			return scourse;
		}



		public void setScourse(String scourse) {
			this.scourse = scourse;
		}



		public Student(int sid, String sname, String scontact, String semail, String scourse) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.scontact = scontact;
			this.semail = semail;
			this.scourse = scourse;
		}



		public Student() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
	


}
