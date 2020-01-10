package com.cgt.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.userservice.dto.BooleanResult;
import com.cgt.userservice.dto.LogginCredentials;
import com.cgt.userservice.dto.UserDto;
import com.cgt.userservice.dto.UserList;
import com.cgt.userservice.dto.UserProfile;
import com.cgt.userservice.entity.User;
import com.cgt.userservice.facade.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/validUser")
	public ResponseEntity<UserDto> validUser(@RequestBody LogginCredentials login) {
		UserDto user = this.userService.validUser(login.getUsername(), login.getPassword());
		if(user!=null)
			return new ResponseEntity<>(user,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/addUser")
	public ResponseEntity<BooleanResult> addUser(@RequestBody User user) {
		user.setIsactive(1);
		return new ResponseEntity<>(new BooleanResult(this.userService.addUser(user)),HttpStatus.OK);
	}
	
	@RequestMapping("/getUser/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
		return new ResponseEntity<>(this.userService.getUser(id),HttpStatus.OK);
	}
	
	@RequestMapping("/blockUser/{id}")
	public ResponseEntity<BooleanResult> blockUser(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.userService.blockUser(id)),HttpStatus.OK);
	}
	
	@RequestMapping("/unblockUser/{id}")
	public ResponseEntity<BooleanResult> unblockUser(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.userService.unblockUser(id)),HttpStatus.OK);
	}
	
	@RequestMapping("/getAllUser")
	public ResponseEntity<UserList>getAllUsers(){
		return new ResponseEntity<>(new UserList(this.userService.getAllUser()),HttpStatus.OK);		
	}
	
	@RequestMapping("/getProfile/{user_id}")
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable Integer user_id){
		return new ResponseEntity<>(this.userService.editProfile(user_id),HttpStatus.OK);	
	}
	
	@RequestMapping("/updateMentorProfile")
	public ResponseEntity<BooleanResult> updateMentorProfile(@RequestBody UserProfile user){
		return new ResponseEntity<>(new BooleanResult(this.userService.updateMentorProfile(user)),HttpStatus.OK);	
	}
	
}
