package com.cgt.mentorondemand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.mentorondemand.dto.LogginCredential;
import com.cgt.mentorondemand.dto.UserDto;
import com.cgt.mentorondemand.facade.MentorOnDemandService;

@RestController
public class HomeController {

	@Autowired
	private MentorOnDemandService service;
	
	@RequestMapping("/login")
	public ResponseEntity<UserDto> validateUser(@RequestBody LogginCredential login){
		UserDto user = this.service.validateUser(login);
		if(user==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.service.validateUser(login),HttpStatus.FOUND);
	}
}
