package com.cgt.roleservice.dto;

import java.util.List;

import com.cgt.roleservice.entity.Roles;

import lombok.Data;

@Data
public class RoleList {

	List<Roles> roles;
	
	public RoleList() {}

	public RoleList(List<Roles> roles) {
		super();
		this.roles = roles;
	}
	
	
}
