package com.DAO.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.POJO.basics.Attendance;


public class AttendanceDAO {

	public Connection getConnect() {
		String user = "root";
		String passw = "";
		String url = "jdbc:mysql://localhost:3306/collegejava2021";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void addStudentAttCheck(Attendance att) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, att.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					addStudentAtt(att);
					System.out.println("Data Added Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + att.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudentAtt(Attendance att) {
		try {
			String sql = "insert into attendance(sid,sname,attendance) values(?,?,?)";
			PreparedStatement ps = getConnect().prepareStatement(sql);
			ps.setInt(1, att.getStid());
			ps.setString(2, att.getStname());
			ps.setString(3, att.getAttendance());
			ps.execute();
			getConnect().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudentAttCheck(Attendance att) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, att.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					updateStudentAtt(att);
					System.out.println("Data Updated Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + att.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStudentAtt(Attendance att) {
		try {
			String sql = "update fee set sname=?,sfstatus=? where sid=?";
			PreparedStatement ps = getConnect().prepareStatement(sql);

			ps.setString(1, att.getStname());
			ps.setString(2, att.getAttendance());

			ps.setInt(3, att.getStid());

			ps.execute();
			getConnect().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAllStudentAtt() {
		try {
			String sql = "select * from attendance";
			PreparedStatement ps = getConnect().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("**************************************************************");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectStudentByIdAttCheck(Attendance att) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, att.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					selectStudentByIdAtt(att.getStid());
					

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + att.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStudentByIdAtt(int stid) {
		try {
			String sql = "select * from attendance where sid=?";
			PreparedStatement ps = getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ResultSet rs = ps.executeQuery();
			System.out.println("**************************************************************");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentattCheck(Attendance att) {
		try {
			String sql1 = "select exists(select * from student where sid=?);";
			PreparedStatement ps1 = getConnect().prepareStatement(sql1);
			ps1.setInt(1, att.getStid());
			ps1.execute();
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				int x = rs1.getInt(1);
				if (x == 1) {

					deleteStudentAtt(att.getStid());
					System.out.println("Data deleted Successfully...");

				} else {
					System.out.println("**************************************************************");
					System.out.println("Student having " + att.getStid() + " is not present in Student database...");
				}
			}

			getConnect().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentAtt(int stid) {
		try {
			String sql = "delete  from fee where sid=?";
			PreparedStatement ps = getConnect().prepareStatement(sql);
			ps.setInt(1, stid);
			ps.execute();
			getConnect().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAllStudentByAttendance(String attendance) {
		try {
			String sql = "select * from attendance where attendance like '%" + attendance + "%'";
			PreparedStatement ps = getConnect().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("**************************************************************");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("**************************************************************");
			getConnect().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAllStudentAttList(){
		try {
			String sql="select * FROM student LEFT JOIN attendance ON student.sid = attendance.sid UNION select * from student right join attendance on student.sid = attendance.sid";
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

}
