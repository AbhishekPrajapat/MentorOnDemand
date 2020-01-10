package com.cgt.mentorondemand.entities;

import lombok.Data;

@Data
public class Technologies {

	private Integer id;

	private String technology_name;

	private Integer isactive;
		
	public Technologies() {}
}
