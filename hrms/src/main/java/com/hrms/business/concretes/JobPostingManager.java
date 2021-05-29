package com.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobPostingService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.ErrorResult;
import com.hrms.core.results.Result;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.results.SuccessResult;
import com.hrms.entities.concretes.JobPosting;

import com.hrms.dataAccess.abstracts.JobPostingDao;
@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add (JobPosting jobPosting) {
		if (jobPosting.getCity()==null ||
			jobPosting.getDescription()==null ||
			jobPosting.getVacantPosition()==0 ||
			jobPosting.getApplicationDeadline()==null) {
			 return new ErrorResult("gerekli alanları doldurunuz");
		}
		jobPosting.setPublishedDate(LocalDate.now());
		this.jobPostingDao.save(jobPosting);
		return  new SuccessResult("eklendiniz");
	}

	

	

	@Override
	public Result changeStatus(int id) {
		JobPosting jobPostingToChange = this.jobPostingDao.findById(id).get();
		jobPostingToChange.setActive(!jobPostingToChange.isActive());
		this.jobPostingDao.save(jobPostingToChange);
		return new SuccessResult("Durum DEğiştirildi");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<>(this.jobPostingDao.findAll());
	}

	@Override
	public DataResult<List<JobPosting>> getAllByApplicationDeadline(LocalDate date) {
		
		return new SuccessDataResult<>(this.jobPostingDao.getAllByApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobPosting>> getAllByEmployer(int employerId) {
		
		return new SuccessDataResult<>(this.jobPostingDao.getAllByEmployer(employerId));
	}

}
