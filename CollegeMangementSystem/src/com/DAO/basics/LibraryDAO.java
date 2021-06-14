package com.DAO.basics;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.POJO.basics.Library;





public class LibraryDAO {

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
	
	public void addStudentLibCheck(Library l) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, l.getStdid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					addStudentLib(l);
					System.out.println("Data Added Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + l.getStdid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudentLib(Library l){
		try {
			String sql="insert into library(sid,sname,book,issuedate,returndate) values(?,?,?,?,?)";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, l.getStdid());
			ps.setString(2, l.getStdname());
			ps.setString(3, l.getBook());
			ps.setString(4, l.getIdate());
			ps.setString(5, l.getRdate());
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentLibCheck(Library l) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, l.getStdid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					updateStudentLib(l);
					System.out.println("Data Updated Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + l.getStdid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudentLib(Library l){
		try {
			String sql="update library set sname=?,book=?,issuedate=?,returndate=? where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			
			
			
			ps.setString(1, l.getStdname());
			ps.setString(2, l.getBook());
			ps.setString(3, l.getIdate());
			ps.setString(4, l.getRdate());
			
			ps.setInt(5, l.getStdid());
			
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void selectStudentByIdLibCheck(Library l) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, l.getStdid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					selectStudentByIdLib(l.getStdid());
					

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + l.getStdid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentByIdLib(int stid){
		try {
			String sql="select * from library where sid=?";
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
	
	public void deleteStudentLibCheck(Library l) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, l.getStdid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					deleteStudentLib(l.getStdid());
					System.out.println("Data deleted Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + l.getStdid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentLib(int stid){
		try {
			String sql="delete  from library where sid=?";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ps.execute();
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudentLib(){
		try {
			String sql="select * FROM student LEFT JOIN library ON student.sid = library.sid UNION select * from student right join library on student.sid = library.sid";
			PreparedStatement ps=getConnect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("**************************************************************");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(5)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10));
			}
			System.out.println("**************************************************************");
			System.out.println("#null data have to insert not to update");
			getConnect().close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	

	

}


