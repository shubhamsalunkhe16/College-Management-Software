package com.DAO.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.POJO.basics.Teacher;


public class TeacherDAO {

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

	public void addTeacher(Teacher t){
		try {
			String sql="insert into teacher(tid,tname,tcontact,temail,tqualification) values(?,?,?,?,?)";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, t.getTid());
			ps.setString(2, t.getTname());
			ps.setString(3, t.getTcontact());
			ps.setString(4, t.getTemail());
			ps.setString(5, t.getTqualification());
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTeacherCheck(Teacher t){
		try {
			String sql1="select exists(select * from teacher where tid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, t.getTid());
			ps1.execute();
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int x=rs.getInt(1);
				if(x==1) {
					
					updateTeacher(t);
					System.out.println("Data Upadated Successfully...");
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println(t.getTid()+" is not present in database...");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTeacher(Teacher t){
		try {
			String sql="update teacher set tname=?,tcontact=?,temail=?,tqualification=? where tid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			
			
			ps.setString(1, t.getTname());
			ps.setString(2, t.getTcontact());
			ps.setString(3, t.getTemail());
			ps.setString(4, t.getTqualification());
			
			ps.setInt(5, t.getTid());
			
			
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllTeacher(){
		try {
			String sql="select * from teacher";
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
	
	public void selectTeacherByIdCheck(Teacher t){
		try {
			String sql1="select exists(select * from teacher where tid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, t.getTid());
			ps1.execute();
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int x=rs.getInt(1);
				if(x==1) {
					
					selectTeacherById(t.getTid());
					
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println(t.getTid()+" is not present in database...");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectTeacherById(int tcid){
		try {
			String sql="select * from teacher where tid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, tcid);
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
	
	public void deleteTeacherCheck(Teacher t){
		try {
			String sql1="select exists(select * from teacher where tid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, t.getTid());
			ps1.execute();
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int x=rs.getInt(1);
				if(x==1) {
					
					deleteTeacher(t.getTid());
					System.out.println("Data deleted Successfully...");
					
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println(t.getTid()+" is not present in database...");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTeacher(int tcid){
		try {
			String sql="delete  from teacher where tid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, tcid);
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

