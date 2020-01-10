package com.cgt.userservice.dto;

import lombok.Data;

@Data
public class LogginCredentials {
	
	private String username;
	private String password;

	public LogginCredentials() {}
	
}
