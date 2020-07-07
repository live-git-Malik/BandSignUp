package com.BandStudents.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.BandStudents.model.Student;

public class StudentRepository {
	public Student getFirstStudent() {
		try {
			// product fetched from the db
			Student students = new Student();
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alcorn_band", "root",
					"gu00re705A$");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from students");
			// Iterate the resultSet
			if (resultSet.next()) {
				students.setAnumberID(resultSet.getString("Anumber_ID"));
				students.setStudentName(resultSet.getString("Student_Name"));
				students.setFee(resultSet.getFloat("Band_Fee"));
				students.setInstrument(resultSet.getString("Instrument"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			return students;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error : " + e);
		}
		return null;

	}

	public List<Student> getStudent() {
		try {
			// products fetched from the db
			List<Student> studentList = new ArrayList<Student>();
			Student students = null;
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alcorn_band", "root",
					"gu00re705A$");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from students");
			// Iterate the resultSet
			while (resultSet.next()) {
				students = new Student();
				students.setAnumberID(resultSet.getString("Anumber_ID"));
				students.setStudentName(resultSet.getString("Student_Name"));
				students.setFee(resultSet.getFloat("Band_Fee"));
				students.setInstrument(resultSet.getString("Instrument"));
				studentList.add(students);
			}
			resultSet.close();
			statement.close();
			connection.close();
			System.out.println(studentList);
			return studentList;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean saveStudent(Student student) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alcorn_band", "root",
					"gu00re705A$");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			String insertQuery = "INSERT INTO students (Anumber_ID, Student_Name, Band_Fee, Instrument) VALUES ('"
					+ student.getAnumberID() + "','" + student.getStudentName() + "', " + student.getFee() + ", '"
					+ student.getInstrument() + "');";
			// "insert into students values ('" + student.getAnumberID() + "','"
			// + student.getStudentName() + "'," + student.getFee() + ",'" +
			// student.getInstrument() + "')";
			System.out.println(insertQuery);
			statement.executeUpdate(insertQuery);
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean deleteStudent(String AnumberID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alcorn_band", "root",
					"gu00re705A$");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			String deleteQuery = "DELETE FROM students WHERE Anumber_ID = '" + AnumberID + "'";
			System.out.println(deleteQuery);
			statement.executeUpdate(deleteQuery);
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return false;
	}
}
