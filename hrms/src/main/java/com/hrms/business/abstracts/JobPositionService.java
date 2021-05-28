package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobPosition;



public interface JobPositionService {
	
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);

}