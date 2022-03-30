package College.SpringBootProject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import College.SpringBootProject.Repository.StudentRepo;
import College.SpringBootProject.entities.Student;
import College.SpringBootProject.exception.ResourceNotFoundException;
import College.SpringBootProject.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepo studentRepo;
	

	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}


	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}


	@Override
	public Student getStudentById(long id) {
		
		Optional<Student>student=studentRepo.findById(id);
		if(student.isPresent())
		{
			return student.get();
		}
		else
		{
			throw new ResourceNotFoundException("Student","id","id");
		}
	}


	@Override
	public Student updateStudent(Student student, long id) {
		//check whether student with given Id is exist or Not
		
		Student existingStudent=studentRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student","id","id"));
		
		existingStudent.setStu_name(student.getStu_name());
		existingStudent.setStu_email(student.getStu_email());
		existingStudent.setStu_phone(student.getStu_phone());
		
		//save existing student to DB
		studentRepo.save(existingStudent);
		return existingStudent;
	}


	@Override
	public void deleteStudent(long id) {
		////check whether student with given Id is exist or Not
		studentRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student","id","id"));
		studentRepo.deleteById(id);
		
	}

}
