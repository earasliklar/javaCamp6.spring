package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();

}