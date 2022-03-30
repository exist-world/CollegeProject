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

import College.SpringBootProject.entities.BatchClass;
import College.SpringBootProject.service.BatchClassService;


@RestController
@RequestMapping("/batchClass")

public class BatchClassController {
	
	@Autowired
	private BatchClassService batchClassService;

	public BatchClassController(BatchClassService batchClassService) 
	{
		super();
		this.batchClassService = batchClassService;
	}
	
	//create batchClass
	@PostMapping()
	public ResponseEntity<BatchClass> saveBatchClass(@RequestBody BatchClass batchClass)
	{
	    return new ResponseEntity<BatchClass>(batchClassService.
				saveBatchClass(batchClass), HttpStatus.CREATED);
	}
	

	//get all batchClass
	@GetMapping()
	public List<BatchClass> getAllBatchClass()
	{
		return batchClassService.getAllBatchClass();
		
	}
	
	//get batchClass ById
	@GetMapping("{id}")
	public ResponseEntity<BatchClass> getBatchClassById(@PathVariable("id")long batchClassId)
	{
		return new ResponseEntity<BatchClass>(batchClassService.
					getBatchClassById(batchClassId), HttpStatus.OK);
			
	}
	

	//update batchClass
	@PutMapping("{id}")
	public ResponseEntity<BatchClass> updateBatchClass
	(@PathVariable("id") long id,@RequestBody BatchClass batchClass)
	{
		return new ResponseEntity<BatchClass>(batchClassService.
				updateBatchClass(batchClass, id), HttpStatus.OK);
		
	}
	

	// delete batchClass
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletebatchClass(@PathVariable("id") long id)
	{
		//delete student from DB
		batchClassService.deleteBatchClass(id);
		return new ResponseEntity<String>("BatchClass deleted successfully!", HttpStatus.OK);
		
	}

	
//	@Autowired
//	private ClassRepo classRepo;
//	
//	public ClassController() 
//	{
//	}
//	
//	//getAll
//   @GetMapping("/class")
//   public List<Class> getAllClass()
//	{
//		return classRepo.findAll();
//	}
//	
//	//getById
//	@GetMapping("/class/{classId}")
//	 public Class getClass(long classId)
//	{
//		 return  classRepo.getById(classId);
//	 
//	 }
//
//	//add
//	@PostMapping("/class")
//	public Class addclass(Class classes)
//	{
//		classRepo.save(classes);
//		return classes;
//	}
//	
//	//update
//	@PutMapping("/class")
//	public Class updateclass(Class classes) 
//	{
//		classRepo.save(classes);
//		 return classes;
//	 }
//	
//	//delete
//	@DeleteMapping
//	public void deleteClass(long parseLong) {
//		Class entity=classRepo.getById(parseLong);
//		classRepo.delete(entity);
//	 }

	
}
