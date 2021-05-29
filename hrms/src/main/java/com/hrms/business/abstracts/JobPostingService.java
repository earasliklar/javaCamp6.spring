package com.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	Result add(JobPosting jobposting);
	Result changeStatus(int id);
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getAllByApplicationDeadline(LocalDate date);
	DataResult<List<JobPosting>> getAllByEmployer(int employerId);
}
