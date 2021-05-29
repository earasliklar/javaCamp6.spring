package com.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.JobPostingService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingController {
	
	private JobPostingService jobPostingService;
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
		
	}
	@PostMapping("/changestatus")
	public Result changeStatus(@RequestParam int id) {
		return this.jobPostingService.changeStatus(id);
		}
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@GetMapping("/getallbyapplicationdatetime")
	public DataResult<List<JobPosting>>getAllByApplicationDeadLine(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		return this.jobPostingService.getAllByApplicationDeadline(date);
				}
	@GetMapping("/getallbyemployer")
	public DataResult<List<JobPosting>>getAllByEmployerId(int id){
		return this.jobPostingService.getAllByEmployer(id);
		
	}
}
