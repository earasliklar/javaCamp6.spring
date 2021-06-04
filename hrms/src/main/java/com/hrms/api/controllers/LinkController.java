package com.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.LinkService;
import com.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/linkcontroller")
public class LinkController {
	
	private LinkService linkService;
	@Autowired
	public LinkController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Link	link ){
		return ResponseEntity.ok(this.linkService.add(link));
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.linkService.getAll());
	}
	
}