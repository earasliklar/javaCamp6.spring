package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.CandidateEducationService;
import com.hrms.entities.concretes.CandidateEducaiton;

@RestController
@RequestMapping("/api/candidateeducation")
public class CandidateEducationController {
	private CandidateEducationService candidateEducationService;
	
	@Autowired
	public CandidateEducationController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateEducaiton candidateEducation){
		return ResponseEntity.ok(this.candidateEducationService.add(candidateEducation));
	
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(this.candidateEducationService.getAll());
	}
	
	@GetMapping("/getallbycandidateidorderbygraduationyear")
	public ResponseEntity<?>getallbycandidateidorderbygraduationyear(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateEducationService.getAllByCandidateIdOrderByGraduationYear(candidateId));
	}	

}
