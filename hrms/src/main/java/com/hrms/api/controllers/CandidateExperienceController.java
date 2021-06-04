package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.CandidateExperienceService;
import com.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/candidateexperience")
public class CandidateExperienceController {

	private CandidateExperienceService candidateExperienceService;
	@Autowired
	public CandidateExperienceController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateExperience candidateExperience){
		return ResponseEntity.ok(candidateExperienceService.add(candidateExperience));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(candidateExperienceService.getAll());
	}
	@GetMapping("/getallbycandidateidorderbyleavedate")
	public ResponseEntity<?>getAllByCandidateIdOrderByEndDate(@RequestParam int candidateId){
		return ResponseEntity.ok(candidateExperienceService.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
	}

}
