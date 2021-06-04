package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.CandidateForeignLanguageService;
import com.hrms.entities.concretes.CandidateForeignLanguage;

@RestController
@RequestMapping("/api/candiateforeignlanguage")
public class CandidateForeignLanguageController {
	
	private CandidateForeignLanguageService candidateForeignLanguageService;
	@Autowired
	public CandidateForeignLanguageController(CandidateForeignLanguageService candidateForeignLanguageService) {
		super();
		this.candidateForeignLanguageService = candidateForeignLanguageService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CandidateForeignLanguage candidateForeignLanguage){
		return ResponseEntity.ok(this.candidateForeignLanguageService.add(candidateForeignLanguage));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateForeignLanguageService.getAll());
	}
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateForeignLanguageService.getAllByCandidateId(candidateId));
	}

}
