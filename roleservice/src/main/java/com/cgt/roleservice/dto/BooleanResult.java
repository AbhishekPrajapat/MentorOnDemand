package com.cgt.roleservice.dto;

import lombok.Data;

@Data
public class BooleanResult {

	boolean status;

	public BooleanResult(boolean status) {
		super();
		this.status = status;
	}
	

}
