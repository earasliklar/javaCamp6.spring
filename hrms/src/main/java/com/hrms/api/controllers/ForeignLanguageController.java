package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.ForeignLanguageService;
import com.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguageservice")
public class ForeignLanguageController {
	
	private ForeignLanguageService foreignLanguageService;
	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ForeignLanguage foreignLanguage){
		return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.foreignLanguageService.getAll());
	}
	
}