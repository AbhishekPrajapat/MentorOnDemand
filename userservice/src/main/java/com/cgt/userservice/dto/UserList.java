package com.cgt.userservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserList {

	List<UserDto> userList;
	
	public UserList() {}

	public UserList(List<UserDto> userList) {
		super();
		this.userList = userList;
	}
	
}
