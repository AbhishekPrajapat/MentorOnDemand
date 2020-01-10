package com.cgt.mentorondemand.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.mentorondemand.dto.SearchList;
import com.cgt.mentorondemand.dto.TechnologyList;
import com.cgt.mentorondemand.facade.MentorOnDemandService;

@RestController
public class SearchController {
	
	@Autowired
	private MentorOnDemandService service;

	@RequestMapping("/getSearch/{tech_id}")
	public ResponseEntity<SearchList> getSearchResult(@PathVariable Integer tech_id) {
		return new ResponseEntity<>(new SearchList(this.service.getSearchResult(tech_id)),HttpStatus.OK);
	}
	
	@RequestMapping("/getTechList")
	public ResponseEntity<TechnologyList> getTechList(){
		return new ResponseEntity<>(this.service.getTechList(),HttpStatus.OK);
	}
}
