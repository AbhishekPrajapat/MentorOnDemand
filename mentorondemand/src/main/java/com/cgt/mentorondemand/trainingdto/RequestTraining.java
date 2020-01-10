package com.cgt.mentorondemand.trainingdto;

import lombok.Data;

@Data
public class RequestTraining {
	
	private Integer id;
	private String name;
	private String slot;
	private String techName;
	public RequestTraining(Integer id, String name, String slot, String techName) {
		super();
		this.id = id;
		this.name = name;
		this.slot = slot;
		this.techName = techName;
	}
	
	
}
