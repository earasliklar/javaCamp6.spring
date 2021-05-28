package com.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.CandidateService;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.Result;
import com.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate){
		return this.candidateService.add(candidate);
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}

	
}