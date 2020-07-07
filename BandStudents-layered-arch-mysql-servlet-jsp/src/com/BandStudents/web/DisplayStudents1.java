package com.BandStudents.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BandStudents.model.Student;
import com.BandStudents.service.StudentService;

public class DisplayStudents1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	// The service method
	// ACCEPTS REQUEST FROM THE BROWSER
	// PROCESSES THE REQUEST
	// SEND A RESPONSE
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// directly hitting the repository (not a good practice)
//		{
		// Access the Repository to fetch the Products
//			StudentRepository studentRepository = new StudentRepository();
//			Student students = studentRepository.getFirstStudent();

		// Generate the html output
//			PrintWriter printWriter = resp.getWriter();
//			printWriter.println("<!DOCTYPE html>");
//			printWriter.println("<html>");
//			printWriter.println("<head>");
//			printWriter.println("<title>Display Students</title>");
//			printWriter.println("</head>");
//			printWriter.println("<body>");
//			printWriter.println("<h1>Band Students : </h1>");
//			printWriter.println("<h3>" + students.getAnumberID() + "</h3>");
//			printWriter.println("<h3>" + students.getStudentName() + "</h3>");
//			printWriter.println("<h3>" + students.getFee() + "</h3>");
//			printWriter.println("<h3>" + students.getInstrument() + "</h3>");
//			printWriter.println("</body>");
//			printWriter.println("</html>");
//		}
		// a good practice using the service layer
		// Access the Repository to fetch the Products
		System.out.println("NOW USING THE SERVICE LAYER!");
		StudentService studentService = new StudentService();
		List<Student> students = studentService.getStudent();
		// Generate the html output
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Display All Products</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>First Product : </h1>");
		for (Student product : students) {
			printWriter.println("<h4>" + product.getAnumberID() + "</h4>");
			printWriter.println("<h4>" + product.getStudentName() + "</h4>");
			printWriter.println("<h4>" + product.getFee() + "</h4>");
			printWriter.println("<h4>" + product.getInstrument() + "<h4/>");
			printWriter.println("<hr/>");
		}
		printWriter.println("</body>");
		printWriter.println("</html>");
	}
}
