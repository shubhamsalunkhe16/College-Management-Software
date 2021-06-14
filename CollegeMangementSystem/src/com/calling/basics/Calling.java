
package com.calling.basics;

import java.util.Scanner;

import com.DAO.basics.AttendanceDAO;
import com.DAO.basics.FeeDAO;
import com.DAO.basics.LibraryDAO;
import com.DAO.basics.MarksDAO;
import com.DAO.basics.StudentDAO;
import com.DAO.basics.TeacherDAO;
import com.POJO.basics.Attendance;
import com.POJO.basics.Fee;
import com.POJO.basics.Library;
import com.POJO.basics.Marks;
import com.POJO.basics.Student;
import com.POJO.basics.Teacher;

public class Calling {
	Scanner sc = new Scanner(System.in);

	public void studentOperations() {
		int id;
		String name;
		String email;
		String contact;
		String course;
		int choice = 0;

		StudentDAO sd = new StudentDAO();
		Student s = new Student();
		do {
			System.out.println("Enter 1 For Insert : ");
			System.out.println("      2 For Update : ");
			System.out.println("      3 For SelectById : ");
			System.out.println("      4 For Delete : ");
			System.out.println("      5 For SelectAll : ");
			System.out.println("      6 For SelectAllByCourse : ");
			System.out.println("      0 For Exit : ");
			System.out.println("**************************************************************");
			System.out.println("Please select your option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Contact no.: ");
				contact = sc.next();
				System.out.print("Enter Email: ");
				email = sc.next();
				System.out.print("Enter Course code: ");
				course = sc.next();

				s.setSname(name);
				s.setScourse(course);
				s.setScontact(contact);
				s.setSemail(email);
				sd.addStudent(s);
				System.out.println("Data Added Successfully...");
				System.out.println("**************************************************************");

				break;

			case 2:

				System.out.print("Enter Id to Update Data: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Contact no.: ");
				contact = sc.next();
				System.out.print("Enter Email: ");
				email = sc.next();
				System.out.print("Enter Course code: ");
				course = sc.next();

				s.setSid(id);
				s.setSname(name);
				s.setScourse(course);
				s.setScontact(contact);
				s.setSemail(email);

				sd.updateStudentCheck(s);

				System.out.println("**************************************************************");
				break;

			case 3:
				System.out.print("Enter Id for To select Student: ");
				id = sc.nextInt();
				s.setSid(id);
				sd.selectStudentByIdCheck(s);
				break;

			case 4:
				System.out.print("Enter Id for To Delete Student: ");
				id = sc.nextInt();
				s.setSid(id);
				sd.deleteStudentCheck(s);

				break;

			case 5:
				sd.selectAllStudent();
				break;

			case 6:
				System.out.print("Enter Course: ");
				course = sc.next();
				sd.selectAllStudentByCourse(course);
				break;

			case 0:

				choice = 0;
				break;

			default:
				System.out.println("Select A valid Option");
				break;
			}

		} while (choice != 0);
	}

	public void teacherOperations() {
		int id;
		String name;
		String email;
		String contact;
		String qualification;
		int choice = 0;

		TeacherDAO td = new TeacherDAO();
		Teacher t = new Teacher();

		do {
			System.out.println("Enter 1 For Insert : ");
			System.out.println("      2 For Update : ");
			System.out.println("      3 For SelectById : ");
			System.out.println("      4 For Delete : ");
			System.out.println("      5 For SelectAll : ");
			System.out.println("      0 For Exit : ");
			System.out.println("**************************************************************");
			System.out.println("Please select your option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Contact no.: ");
				contact = sc.next();
				System.out.print("Enter Email: ");
				email = sc.next();
				System.out.print("Enter qualification: ");
				qualification = sc.next();

				t.setTname(name);
				t.setTqualification(qualification);
				t.setTcontact(contact);
				t.setTemail(email);
				td.addTeacher(t);
				System.out.println("Data Added Successfully...");
				System.out.println("**************************************************************");

				break;

			case 2:

				System.out.print("Enter Id to Update Data: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Contact no.: ");
				contact = sc.next();
				System.out.print("Enter Email: ");
				email = sc.next();
				System.out.print("Enter Qualification: ");
				qualification = sc.next();
				t.setTid(id);
				t.setTname(name);
				t.setTqualification(qualification);
				t.setTcontact(contact);
				t.setTemail(email);

				td.updateTeacherCheck(t);

				System.out.println("**************************************************************");
				break;

			case 3:
				System.out.print("Enter Id for To select teacher: ");
				id = sc.nextInt();
				t.setTid(id);
				td.selectTeacherByIdCheck(t);
				break;

			case 4:
				System.out.print("Enter Id for To Delete Teacher: ");
				id = sc.nextInt();
				t.setTid(id);
				td.deleteTeacherCheck(t);

				break;

			case 5:
				td.selectAllTeacher();
				break;

			case 0:

				choice = 0;
				break;

			default:
				System.out.println("Select A valid Option");
				break;
			}

		} while (choice != 0);
	}

	public void feeOperations() {
		int id;
		String name;
		String status;
		int choice = 0;

		FeeDAO fd = new FeeDAO();
		Fee f = new Fee();
		do {
			System.out.println("Enter 1 For Insert : ");
			System.out.println("      2 For Update : ");
			System.out.println("      3 For SelectById : ");
			System.out.println("      4 For Delete : ");
			System.out.println("      5 For SelectAll : ");
			System.out.println("      6 For selectAllStudentFeeList : ");
			System.out.println("      7 For SelectAllByFeeStatus : ");
			System.out.println("      0 For Exit : ");
			System.out.println("**************************************************************");
			System.out.println("Please select your option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Id: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Fee Status: ");
				status = sc.next();

				f.setSid(id);
				f.setSname(name);
				f.setSfstatus(status);
				fd.addStudentFeeCheck(f);

				System.out.println("**************************************************************");

				break;

			case 2:

				System.out.print("Enter Id to Update Data: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Fee Status: ");
				status = sc.next();
				f.setSid(id);
				f.setSname(name);
				f.setSfstatus(status);

				fd.updateStudentFeeCheck(f);

				System.out.println("**************************************************************");
				break;

			case 3:
				System.out.print("Enter Id for To select Student: ");
				id = sc.nextInt();
				f.setSid(id);
				fd.selectStudentByIdFeeCheck(f);
				break;

			case 4:
				System.out.print("Enter Id for To Delete Student: ");
				id = sc.nextInt();
				f.setSid(id);
				fd.deleteStudentFee(id);
				System.out.println("Data deleted Successfully...");
				break;

			case 5:

				fd.selectAllStudentFee();
				break;

			case 7:
				System.out.print("Enter Fee Status: ");
				status = sc.next();
				f.setSfstatus(status);
				fd.selectAllStudentByFeestatus(status);
				break;

			case 6:
				fd.selectAllStudentFeeList();
				break;

			case 0:

				choice = 0;
				break;

			default:
				System.out.println("Select A valid Option");
				break;
			}

		} while (choice != 0);
	}

	public void attendanceOperations() {
		int id;
		String name;
		String attendance;
		int choice = 0;

		AttendanceDAO ad = new AttendanceDAO();
		Attendance att = new Attendance();
		do {
			System.out.println("Enter 1 For Insert : ");
			System.out.println("      2 For Update : ");
			System.out.println("      3 For SelectById : ");
			System.out.println("      4 For Delete : ");
			System.out.println("      5 For SelectAll : ");
			System.out.println("      6 For selectAllStudentAttList : ");
			System.out.println("      7 For SelectAllByAttendance : ");
			System.out.println("      0 For Exit : ");
			System.out.println("**************************************************************");
			System.out.println("Please select your option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Id: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Attendance: ");
				attendance = sc.next();

				att.setStid(id);
				att.setStname(name);
				att.setAttendance(attendance);
				ad.addStudentAttCheck(att);

				System.out.println("**************************************************************");

				break;

			case 2:

				System.out.print("Enter Id to Update Data: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Fee Status: ");
				attendance = sc.next();

				att.setStid(id);
				att.setStname(name);
				att.setAttendance(attendance);

				ad.updateStudentAttCheck(att);
				System.out.println("Data Upadated Successfully...");
				System.out.println("**************************************************************");
				break;

			case 3:
				System.out.print("Enter Id for To select Student: ");
				id = sc.nextInt();
				ad.selectStudentByIdAttCheck(att);
				break;

			case 4:
				System.out.print("Enter Id for To Delete Student: ");
				id = sc.nextInt();
				ad.deleteStudentattCheck(att);
				System.out.println("Data deleted Successfully...");
				break;

			case 5:
				ad.selectAllStudentAtt();
				break;

			case 6:
				ad.selectAllStudentAttList();
				break;

			case 7:
				System.out.print("Enter Attendance status : ");
				attendance = sc.next();
				ad.selectAllStudentByAttendance(attendance);
				break;

			case 0:

				choice = 0;
				break;

			default:
				System.out.println("Select A valid Option");
				break;
			}

		} while (choice != 0);
	}

	public void marksOperations() {
		int id;
		String name;
		int phy;
		int chem;
		int bio;
		int choice = 0;

		MarksDAO md = new MarksDAO();
		Marks m = new Marks();
		do {
			System.out.println("Enter 1 For Insert : ");
			System.out.println("      2 For Update : ");
			System.out.println("      3 For SelectById : ");
			System.out.println("      4 For Delete : ");
			System.out.println("      5 For SelectAll : ");
			System.out.println("      0 For Exit : ");
			System.out.println("**************************************************************");
			System.out.println("Please select your option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Id: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Physics Marks: ");
				phy = sc.nextInt();
				System.out.print("Enter Chemistry Marks: ");
				chem = sc.nextInt();
				System.out.print("Enter Biology Marks: ");
				bio = sc.nextInt();

				m.setStid(id);
				m.setStname(name);
				m.setPhy(phy);
				m.setChem(chem);
				m.setBio(bio);
				md.addStudentMarksCheck(m);

				System.out.println("**************************************************************");

				break;

			case 2:

				System.out.print("Enter Id to Update Data: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Physics Marks: ");
				phy = sc.nextInt();
				System.out.print("Enter Chemistry Marks: ");
				chem = sc.nextInt();
				System.out.print("Enter Biology Marks: ");
				bio = sc.nextInt();

				m.setStid(id);
				m.setStname(name);
				m.setPhy(phy);
				m.setChem(chem);
				m.setBio(bio);

				md.updateStudentMarksCheck(m);
				System.out.println("Data Upadated Successfully...");
				System.out.println("**************************************************************");
				break;

			case 3:
				System.out.print("Enter Id for To select Student: ");
				id = sc.nextInt();
				m.setStid(id);
				md.selectStudentByIdMarksCheck(m);
				break;

			case 4:
				System.out.print("Enter Id for To Delete Student: ");
				id = sc.nextInt();
				m.setStid(id);
				md.deleteStudentMarksCheck(m);
				System.out.println("Data deleted Successfully...");
				break;

			case 5:
				md.selectAllStudentMarks();
				break;

			case 0:

				choice = 0;
				break;

			default:
				System.out.println("Select A valid Option");
				break;
			}

		} while (choice != 0);
	}

	public void libraryOperations() {
		int id;
		String name;
		String book;
		String idate;
		String rdate;
		int choice = 0;

		LibraryDAO ld = new LibraryDAO();
		Library l = new Library();
		do {
			System.out.println("Enter 1 For Insert : ");
			System.out.println("      2 For Update : ");
			System.out.println("      3 For SelectById : ");
			System.out.println("      4 For Delete : ");
			System.out.println("      5 For SelectAll : ");
			System.out.println("      0 For Exit : ");
			System.out.println("**************************************************************");
			System.out.println("Please select your option: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter Id: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Book Name: ");
				book = sc.next();
				System.out.print("Enter Issue Date: ");
				idate = sc.next();
				System.out.print("Enter Return Date: ");
				rdate = sc.next();

				l.setStdid(id);
				l.setStdname(name);
				l.setBook(book);
				l.setIdate(idate);
				l.setRdate(rdate);
				ld.addStudentLibCheck(l);

				System.out.println("**************************************************************");
				break;

			case 2:

				System.out.print("Enter Id to Update Data: ");
				id = sc.nextInt();
				System.out.print("Enter Name: ");
				name = sc.next();
				System.out.print("Enter Book Name: ");
				book = sc.next();
				System.out.print("Enter Issue Date: ");
				idate = sc.next();
				System.out.print("Enter Return Date: ");
				rdate = sc.next();

				l.setStdid(id);
				l.setStdname(name);
				l.setBook(book);
				l.setIdate(idate);
				l.setRdate(rdate);

				ld.updateStudentLibCheck(l);

				System.out.println("**************************************************************");
				break;

			case 3:
				System.out.print("Enter Id for To select Student: ");
				id = sc.nextInt();
				l.setStdid(id);
				ld.selectStudentByIdLibCheck(l);
				break;

			case 4:
				System.out.print("Enter Id for To Delete Student: ");
				id = sc.nextInt();
				l.setStdid(id);
				ld.deleteStudentLibCheck(l);
				System.out.println("Data deleted Successfully...");
				break;

			case 5:
				ld.selectAllStudentLib();
				break;

			case 0:

				choice = 0;
				break;

			default:
				System.out.println("Select A valid Option");
				break;
			}

		} while (choice != 0);
	}

	public static void main(String[] args) {
		Calling c = new Calling();
		int key = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("WECLOME TO SBS COLLEGE MANAGEMENT SYSTEM");
				System.out.println("*********************************************");
				System.out.println("Enter 1 for Student Operation");
				System.out.println("      2 for Teacher Operation");
				System.out.println("      3 for Fees Operation");
				System.out.println("      4 for Attendance Operation");
				System.out.println("      5 for Add Marks Operation");
				System.out.println("      6 for Library Operation");
				System.out.println("*********************************************");
				
				
				
				try {
					System.out.println("Please select your option: ");
					key = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Please Enter Number Only");
				}

				switch (key) {
				case 1:
					System.out.println("*********************************************");
					try {
						c.studentOperations();
					} catch (Throwable e) {
						System.out.println("Please Enter only Number");
						
						
					}
					System.out.println("*********************************************");
					break;

				case 2:
					System.out.println("*********************************************");
					try {
						c.teacherOperations();
					} catch (Throwable e) {
						System.out.println("Please Enter only Number");
					}
					System.out.println("*********************************************");
					break;

				case 3:
					System.out.println("*********************************************");
					try {
						c.feeOperations();
					} catch (Throwable e) {
						System.out.println("Please Enter only Number");
					}
					System.out.println("*********************************************");
					break;

				case 4:
					System.out.println("*********************************************");
					try {
						c.attendanceOperations();
					} catch (Throwable e) {
						System.out.println("Please Enter only Number");
					}
					System.out.println("*********************************************");
					break;

				case 5:
					System.out.println("*********************************************");
					try {
						c.marksOperations();
					} catch (Throwable e) {
						System.out.println("Please Enter only Number");
					}
					System.out.println("*********************************************");
					break;

				case 6:
					System.out.println("*********************************************");
					try {
						c.libraryOperations();
					} catch (Throwable e) {
						System.out.println("Please Enter only Number");
					}
					System.out.println("*********************************************");
					break;
				case 0:
					System.out.println("*********************************************");
					System.out.println("Visit Again!!!!");
					key = 0;
					System.out.println("*********************************************");
					break;

				default:
					System.out.println("*********************************************");
					System.out.println("Please Enter Valid Option....");
					System.out.println("*********************************************");
					break;
				}

			} while (key != 0);
		}

	}

}