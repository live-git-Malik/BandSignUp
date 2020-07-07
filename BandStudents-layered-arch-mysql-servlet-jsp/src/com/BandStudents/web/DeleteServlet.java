package com.BandStudents.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BandStudents.service.StudentService;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String AnumberID = request.getParameter("AnumberID");
//		String StudentName = request.getParameter("StudentName");

		StudentService studentService = new StudentService();

		boolean deleted = studentService.deleteStudent(AnumberID);

		if (deleted) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("delete-student.html");
			requestDispatcher.forward(request, response);
		}

	}

}