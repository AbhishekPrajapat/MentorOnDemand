package com.cgt.roleservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.roleservice.dto.BooleanResult;
import com.cgt.roleservice.dto.RoleList;
import com.cgt.roleservice.entity.Roles;
import com.cgt.roleservice.facade.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getAllRole")
	public ResponseEntity<RoleList> getAllRole(){
		List<Roles> roles= this.roleService.getAllRoles();
		
		return new ResponseEntity<>(new RoleList(roles),HttpStatus.OK);
		
	}
	
	@RequestMapping("/getRole/{id}")
	public ResponseEntity<Roles> getRole(@PathVariable Integer id) {
		return new ResponseEntity<>(this.roleService.getRole(id),HttpStatus.OK);
	}
	
	@RequestMapping("/addRole")
	public ResponseEntity<BooleanResult> addRole(@RequestBody Roles role) {
		return new ResponseEntity<>(new BooleanResult(this.roleService.addRole(role)),HttpStatus.OK);
	}
	
	@RequestMapping("/deleteRole/{id}")
	public ResponseEntity<BooleanResult> deleteRole(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.roleService.deleteRole(id)),HttpStatus.OK);
	}
}
