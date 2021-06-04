package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.CandidateProgrammingLanguageService;
import com.hrms.entities.concretes.CandidateProgrammingLanguage;

@RestController
@RequestMapping("/api/candidateprogramminglanguage")
public class CandidateProgrammingLanguageController {
	
	private CandidateProgrammingLanguageService candidateProgrammingLanguageService;
	@Autowired
	public CandidateProgrammingLanguageController(CandidateProgrammingLanguageService CandidateProgrammingLanguageService) {
		super();
		this.candidateProgrammingLanguageService = CandidateProgrammingLanguageService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateProgrammingLanguage candidateProgrammingLanguage){
		return ResponseEntity.ok(this.candidateProgrammingLanguageService.add(candidateProgrammingLanguage));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateProgrammingLanguageService.getAll());
	}
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateProgrammingLanguageService.getAllByCandidateId(candidateId));
	}

}
