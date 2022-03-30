package College.SpringBootProject.service;

import java.util.List;

import College.SpringBootProject.entities.Student;

public interface StudentService {

	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long id);
	Student updateStudent(Student student,long id);
	void deleteStudent(long id);
}
