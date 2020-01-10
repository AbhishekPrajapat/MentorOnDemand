package com.cgt.userservice.dto;

import lombok.Data;

@Data
public class BooleanResult {
	
	boolean status;

	public BooleanResult(boolean status) {
		super();
		this.status = status;
	}
	

}
