package com.cgt.technologies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.technologies.dto.BooleanResult;
import com.cgt.technologies.dto.TechnologyList;
import com.cgt.technologies.entity.Technologies;
import com.cgt.technologies.facade.TechnologyService;

@RestController
public class TechnologyController {
	
	@Autowired
	private TechnologyService techService;
	
	@RequestMapping("/getAllTech")
	public ResponseEntity<TechnologyList> getAllTech(){
		List<Technologies> tech = this.techService.getAllTech();
		return new ResponseEntity<>(new TechnologyList(tech),HttpStatus.OK);
	}
	@RequestMapping("/getTech/{id}")
	public ResponseEntity<Technologies> getTech(@PathVariable Integer id) {
		return new ResponseEntity<>(this.techService.getTech(id),HttpStatus.FOUND);
		
	}
	@RequestMapping("/addTech")
	public ResponseEntity<BooleanResult> addTech(@RequestBody Technologies tech) {
		return new ResponseEntity<>(new BooleanResult(this.techService.addTechnology(tech)),HttpStatus.OK);
	}
	@RequestMapping("/deleteTech/{id}")
	public ResponseEntity<BooleanResult> deleteTech(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.techService.deleteTech(id)),HttpStatus.OK);
	}
}
