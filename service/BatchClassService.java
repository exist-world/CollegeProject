package College.SpringBootProject.service;

import java.util.List;

import College.SpringBootProject.entities.BatchClass;



public interface BatchClassService {
	
	BatchClass saveBatchClass(BatchClass batchClass);
	List<BatchClass> getAllBatchClass();
	BatchClass getBatchClassById(long id);
	BatchClass updateBatchClass(BatchClass batchClass,long id);
	void deleteBatchClass(long id);

}
