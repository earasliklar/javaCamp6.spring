package com.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.EmployerService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
       return new SuccessResult("İşveren eklendi.");
	} 
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}


}