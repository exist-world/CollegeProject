package College.SpringBootProject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import College.SpringBootProject.Repository.BatchClassRepo;
import College.SpringBootProject.entities.BatchClass;

import College.SpringBootProject.exception.ResourceNotFoundException;
import College.SpringBootProject.service.BatchClassService;

@Service
public class BatchClassServiceImpl implements BatchClassService{
	
	private BatchClassRepo batchClassRepo;

	public BatchClassServiceImpl(BatchClassRepo batchClassRepo) {
		super();
		this.batchClassRepo = batchClassRepo;
	}

	@Override
	public BatchClass saveBatchClass(BatchClass batchClass) {
		
		return batchClassRepo.save(batchClass);
	}

	@Override
	public List<BatchClass> getAllBatchClass() {
		
		return batchClassRepo.findAll();
	}

	@Override
	public BatchClass getBatchClassById(long id) {
		
		Optional<BatchClass>batchClass=batchClassRepo.findById(id);
		if(batchClass.isPresent())
		{
			return batchClass.get();
		}
		else
		{
			throw new ResourceNotFoundException("BatchClass","id","id");
		}

	}

	@Override
	public BatchClass updateBatchClass(BatchClass batchClass, long id) {
		//check whether batchClass with given Id is exist or Not
		
		BatchClass existingBatchClass=batchClassRepo.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("BatchClass","id","id"));
				
				existingBatchClass.setCl_name(batchClass.getCl_name());
				existingBatchClass.setCl_date(batchClass.getCl_date());
				
				
				//save existing batchClass to DB
				batchClassRepo.save(existingBatchClass);
				return existingBatchClass;
	}

	@Override
	public void deleteBatchClass(long id) {
		
	////check whether batchClass with given Id is exist or Not
		batchClassRepo.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("BatchClass","id","id"));
		batchClassRepo.deleteById(id);
	}

	
}
