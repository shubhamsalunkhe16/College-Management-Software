package com.DAO.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.POJO.basics.Marks;




public class MarksDAO {

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
	
	public void addStudentMarksCheck(Marks m) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, m.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					addStudentMarks(m);
					System.out.println("Data Added Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + m.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudentMarks(Marks m){
		try {
			String sql="insert into marks(sid,sname,sphysics,schemistry,sbiology) values(?,?,?,?,?)";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, m.getStid());
			ps.setString(2, m.getStname());
			ps.setInt(3, m.getPhy());
			ps.setInt(4, m.getChem());
			ps.setInt(5, m.getBio());
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentMarksCheck(Marks m) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, m.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					updateStudentMarks(m);
					System.out.println("Data Updated Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + m.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentMarks(Marks m){
		try {
			String sql="update marks set sname=?,sphysics=?,schemistry=?,sbiology=? where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			
			
			
			ps.setString(1, m.getStname());
			ps.setInt(2, m.getPhy());
			ps.setInt(3, m.getChem());
			ps.setInt(4, m.getBio());
			
			ps.setInt(5, m.getStid());
			
			
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudentMarks(){
		try {
			String sql="select * FROM student LEFT JOIN marks ON student.sid = marks.sid UNION select * from student right join marks on student.sid = marks.sid";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(5)+"\t"+rs.getInt(8)+"\t"+rs.getInt(9)+"\t"+rs.getInt(10));
			}
			System.out.println("**************************************************************");
			System.out.println("#null data have to insert not to update");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentByIdMarksCheck(Marks m) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, m.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					selectStudentByIdMarks(m.getStid());
					

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + m.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentByIdMarks(int stid){
		try {
			String sql="select * from marks where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentMarksCheck(Marks m) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, m.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					deleteStudentMarks(m.getStid());
					

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + m.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentMarks(int stid){
		try {
			String sql="delete  from marks where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
	

	

}


