package College.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import College.SpringBootProject.Repository.StudentRepo;
import College.SpringBootProject.entities.Department;
import College.SpringBootProject.entities.Student;



@RestController
public class StudentController {
	
	@Autowired
	 private StudentRepo studentRepo;
	 
	//getAll
	 @GetMapping("/students")
	 public List<Student> getAllStudent()
	 {
		return studentRepo.findAll();
	 }
	 
    //getById
	 @GetMapping("/students/{studentId}")
	 public Student getStudent (long studentId)
	{
		 return  studentRepo.getById(studentId);
	 }
		 
     //add
	 @PostMapping("/students")
	 public Student addStudent(Student student)
	{
		studentRepo.save(student);
			return student;
	}
	 
	 //update
     @PutMapping("/student")
     public Student updateStudent(Student student) 
 	{
 		 studentRepo.save(student);
 		 return  student;
 	 }
     
	 


}
