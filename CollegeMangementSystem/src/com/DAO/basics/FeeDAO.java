package com.DAO.basics;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.POJO.basics.Fee;





public class FeeDAO {

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


	public void addStudentFeeCheck(Fee f){
		try {
			String sql1="select exists(select * from student where sid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, f.getSid());
			ps1.execute();
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()) {
				int x=rs1.getInt(1);
				if(x==1) {
					
					
					addStudentFee(f);
					System.out.println("Data Added Successfully...");
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println("Student having "+f.getSid()+" is not present in Student database...");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStudentFee(Fee f){
		try {
			String sql="insert into fee(sid,sname,sfstatus) values(?,?,?)";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, f.getSid());
			ps.setString(2, f.getSname());
			ps.setString(3, f.getSfstatus());
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentFeeCheck(Fee f){
		try {
			String sql1="select exists(select * from student where sid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, f.getSid());
			ps1.execute();
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()) {
				int x=rs1.getInt(1);
				if(x==1) {
					
					
					updateStudentFee(f);
					System.out.println("Data Updated Successfully...");
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println("Student having "+f.getSid()+" is not present in Student database...");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentFee(Fee f){
		try {
			String sql="update fee set sname=?,sfstatus=? where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			
			
			ps.setString(1, f.getSname());
			ps.setString(2, f.getSfstatus());
			
			ps.setInt(3, f.getSid());
			
			
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudentFee(){
		try {
			String sql="select * from fee";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"  \t"+rs.getString(3));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudentFeeList(){
		try {
			String sql="select * FROM student LEFT JOIN fee ON student.sid = fee.sid UNION select * from student right join fee on student.sid = fee.sid";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(8));
			}
			System.out.println("**************************************************************");
			System.out.println("#null data have to insert not to update");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectStudentByIdFeeCheck(Fee f){
		try {
			String sql1="select exists(select * from student where sid=?);";
			PreparedStatement ps1=getConnect().prepareStatement(sql1);
			ps1.setInt(1, f.getSid());
			ps1.execute();
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()) {
				int x=rs1.getInt(1);
				if(x==1) {
					
					
					selectStudentByIdFee(f.getSid());
					
					
					
				}
				else {
					System.out.println("**************************************************************");
					System.out.println("Student having "+f.getSid()+" is not present in Student database...");
				}
			}
			
			getConnect().close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentByIdFee(int stid){
		try {
			String sql="select * from fee where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentFee(int stid){
		try {
			String sql="delete  from fee where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectAllStudentByFeestatus(String status){
		try {
			String sql="select * from fee where sfstatus like '%"+status+"%'";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}





	


	

}

