package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.CandidateLinkService;
import com.hrms.entities.concretes.CandidateLink;

@RestController
@RequestMapping("/api/candidatelink")
public class CandidateLinkController {
	
	private CandidateLinkService candidateLinkService;
	@Autowired
	public CandidateLinkController(CandidateLinkService candidateLinkService) {
		super();
		this.candidateLinkService = candidateLinkService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateLink candidateLink){
		return ResponseEntity.ok(this.candidateLinkService.add(candidateLink));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateLinkService.getAll());
	}
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateLinkService.getAllByCandidateId(candidateId));
	}

}
