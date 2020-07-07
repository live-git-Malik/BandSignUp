package com.BandStudents.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BandStudents.model.Student;
import com.BandStudents.service.StudentService;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String AnumberID = request.getParameter("AnumberID");
		String StudentName = request.getParameter("StudentName");
		float fee = Float.parseFloat(request.getParameter("Fee"));
		String Instrument = request.getParameter("Instrument");
		System.out.println(AnumberID);
		System.out.println(StudentName);
		System.out.println(fee);
		System.out.println(Instrument);

		// sending the students to the service layer

		Student student = new Student();
		student.setAnumberID(AnumberID);
		student.setStudentName(StudentName);
		student.setFee(fee);
		student.setInstrument(Instrument);

		StudentService studentService = new StudentService();

		boolean saved = studentService.saveStudent(student);

		if (saved) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("added-student.html");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-student-failed.html");
			requestDispatcher.forward(request, response);
		}
	}

}
