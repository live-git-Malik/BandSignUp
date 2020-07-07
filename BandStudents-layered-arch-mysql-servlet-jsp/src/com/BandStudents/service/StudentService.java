package com.BandStudents.service;

import java.util.List;

import com.BandStudents.model.Student;
import com.BandStudents.repository.StudentRepository;

public class StudentService {
	public Student getFirstStudent() {

		Student students = null;
		StudentRepository studentRepository = new StudentRepository();
		students = studentRepository.getFirstStudent();
		// the service layer applies the discount (business logic)
		students.setFee(students.getFee() + 100);
		return students;
	}

	public List<Student> getStudent() {
		StudentRepository studentRepsitory = new StudentRepository();
		List<Student> student = studentRepsitory.getStudent();
		return student;

	}

	public boolean saveStudent(Student student) {
		StudentRepository studentRepository = new StudentRepository();
		boolean saved = studentRepository.saveStudent(student);
		return saved;
	}

	public boolean deleteStudent(String AnumberID) {
		StudentRepository studentRepository = new StudentRepository();
		studentRepository.deleteStudent(AnumberID);
		return false;
	}
}
