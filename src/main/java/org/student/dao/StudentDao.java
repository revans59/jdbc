package org.student.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import org.student.dto.Student;

import java.sql.ResultSet;

public class StudentDao {
	// Class.forName("com.mysql.cj.jdbc.Driver");

	static {
		System.out.println("Welcome to Students App");

	}

	public static void main(String args[]) {

		while (true) {
			System.out.println("Enter your operation: ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			StudentDao studentDao = new StudentDao();
			Student student = new Student();
			int id;
			double marks;
			switch (choice) {

			case 1:
				studentDao.saveStudent(student);
				break;

			case 2:
				studentDao.displayAll();
				break;

			case 3:
				System.out.println("Enter student id");
				id = sc.nextInt();
				studentDao.findStudentById(id);
				break;
			case 4:
				System.out.println("Enter student id for update");
				id = sc.nextInt();
				System.out.println("Enter student marks for update");
				marks = sc.nextDouble();
				studentDao.updateStudentMarks(id, marks);

			case 5:
				System.out.println("Enter student id for delete");
				id = sc.nextInt();
				studentDao.deleteStudent(id);
				
			case 6:System.out.println("Exit successfull");
				   System.exit(0);	

			}

			// sc.close();
		}

	}

	

	public void saveStudent(Student student) {
		// Insert the student info to the table

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306";

			Connection conn = DriverManager.getConnection(url, "root", "root");

			String query = "INSERT INTO wejem8_jdbc.student VALUES(?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(query);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id: ");
			int id = sc.nextInt();

			student.setId(id);

			System.out.println("Enter name: ");

			String name = sc.next();
			student.setName(name);

			System.out.println("Enter phoneNumber: ");

			Long phoneNumber = sc.nextLong();

			student.setPhoneNumber(phoneNumber);
			System.out.println("Enter Marks: ");

			double marks = sc.nextDouble();

			student.setMarks(marks);
			System.out.println("Enter mailID: ");

			String mailId = sc.next();
			student.setMailId(mailId);
			System.out.println("Enter Gender: ");

			String gender = sc.next();
			// sc.close();
			student.setGender(gender);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setLong(3, student.getPhoneNumber());
			pstmt.setDouble(4, student.getMarks());
			pstmt.setString(5, student.getMailId());
			pstmt.setString(6, student.getGender());

			int res = pstmt.executeUpdate();

			if (res == 1)
				System.out.println("Insert success");

			System.out.println("pstmt" + pstmt);
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void displayAll() {
		// Display All student info to user from the Students table

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306";

			Connection conn = DriverManager.getConnection(url, "root", "root");

			String query = "select * from wejem8_jdbc.student";

			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String phone = res.getString("phone");
				String marks = res.getString("marms");
				String mailid = res.getString("mailid");
				String gender = res.getString("gender");

				System.out.println("id: " + id + "name: " + name + " phone: " + phone + " marks: " + marks + " mailid: "
						+ mailid + " gender: " + gender);

			}
			conn.close();

			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findStudentById(int id) {
		// Display student info based on the student id

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306";

			Connection conn = DriverManager.getConnection(url, "root", "root");

			String query = "select * from wejem8_jdbc.student where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				id = res.getInt("id");
				String name = res.getString("name");
				String phone = res.getString("phone");
				String marks = res.getString("marms");
				String mailid = res.getString("mailid");
				String gender = res.getString("gender");

				System.out.println("id: " + id + "name: " + name + " phone: " + phone + " marks: " + marks + " mailid: "
						+ mailid + " gender: " + gender);

			}
			conn.close();

			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudentMarks(int id, double marks) {
		// update the student marks using student id

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306";

			Connection conn = DriverManager.getConnection(url, "root", "root");

			String query = "update wejem8_jdbc.student set marms=?  where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(2, id);
			pstmt.setDouble(1, marks);

			int res = pstmt.executeUpdate();

			if (res == 1)
				System.out.println("update success");

			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		// Delete the student based on the student id
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306";

			Connection conn = DriverManager.getConnection(url, "root", "root");

			String query = "delete from wejem8_jdbc.student where id=?";

			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();

			if (res == 1)
				System.out.println("delete success");
			else
				System.out.println("Not deleted");

			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
