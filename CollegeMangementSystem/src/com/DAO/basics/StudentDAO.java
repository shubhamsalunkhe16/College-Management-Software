package com.DAO.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.POJO.basics.Student;


public class StudentDAO {

	public Connection getConnect() {
		String user="root";
		String passw="";
		String url="jdbc:mysql://localhost:3306/collegejava2021";

		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,passw)	;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	

	public void addStudent(Student s){
		try {
			String sql="insert into student(sname,scontact,semail,scourse) values(?,?,?,?)";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			
			ps.setString(1, s.getSname());
			ps.setString(2, s.getScontact());
			ps.setString(3, s.getSemail());
			ps.setString(4, s.getScourse());
			ps.execute();
			getConnect().close();
		}catch (Throwable e) {
			System.out.println("Please Enter Number Only");
		}
	}
	
	public void updateStudentCheck(Student s){
		try {
			String sql1="select exists(select * from student where sid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, s.getSid());
			ps1.execute();
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				
				if(rs.getInt(1)==1) {
					
					updateStudent(s);
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println(s.getSid()+" is not present in database...");
				}
			}
			
			getConnect().close();
			
		}catch (Throwable e) {
			System.out.println("Please Enter Number Only");
		}
	}
	
	public void updateStudent(Student s){
		try {
			String sql="update student set sname=?,scontact=?,semail=?,scourse=? where sid=?";
					
					PreparedStatement ps=getConnect().prepareStatement(sql);
					
					
					ps.setString(1, s.getSname());
					ps.setString(2, s.getScontact());
					ps.setString(3, s.getSemail());
					ps.setString(4, s.getScourse());
					
					ps.setInt(5, s.getSid());
					
					
					ps.execute();
					System.out.println("**************************************************************");
					System.out.println("Data Upadated Successfully...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudent(){
		try {
			String sql="select * from Student";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentByIdCheck(Student s){
		try {
			String sql1="select exists(select * from student where sid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, s.getSid());
			ps1.execute();
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int x=rs.getInt(1);
				if(x==1) {
					
					selectStudentById(s.getSid());
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println(s.getSid()+" is not present in database...");
					System.out.println("**************************************************************");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentById(int stid){
		try {
			String sql="select * from Student where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentCheck(Student s){
		try {
			String sql1="select exists(select * from student where sid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, s.getSid());
			ps1.execute();
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int x=rs.getInt(1);
				if(x==1) {
					
					deleteStudent(s.getSid());
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println(s.getSid()+" is not present in database...");
					System.out.println("**************************************************************");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int stid){
		try {
			String sql="delete  from Student where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudentByOrder(){
		try {
			String sql="select * from Student order by name";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAllStudentByCourse(String course){
		try {
			String sql="select * from Student where scourse like '%"+course+"%'";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}

