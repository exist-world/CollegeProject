package College.SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import College.SpringBootProject.entities.Student;
import College.SpringBootProject.service.StudentService;



@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	 private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//create student
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.
				saveStudent(student), HttpStatus.CREATED);
	}
	
	//get all student
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	
	//get student ById
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id")long studentId)
	{
		return new ResponseEntity<Student>(studentService.
				getStudentById(studentId), HttpStatus.OK);
		
	}
	
	//update student
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent
	(@PathVariable("id") long id,@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.
				updateStudent(student, id), HttpStatus.OK);
		
	}
	
	// delete student
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id)
	{
		//delete student from DB
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
		
	}
//	//getAll
//	 @GetMapping("/students")
//	 public List<Student> getAllStudent()
//	 {
//		return studentRepo.findAll();
//	 }
//	 
//    //getById
//	 @GetMapping("/students/{studentId}")
//	 public Student getStudent (long studentId)
//	{
//		 return  studentRepo.getById(studentId);
//	 }
//		 
//     //add
//	 @PostMapping("/students")
//	 public Student addStudent(Student student)
//	{
//		studentRepo.save(student);
//			return student;
//	}
//	 
//	 //update
//     @PutMapping("/student")
//     public Student updateStudent(Student student) 
// 	{
// 		 studentRepo.save(student);
// 		 return  student;
// 	 }
//     
//     @DeleteMapping
// 	public void deleteStudent(long parseLong) {
//    	 Student entity=studentRepo.getById(parseLong);
//    	 studentRepo.delete(entity);
// 	 }
     
	 


}
