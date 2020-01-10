package com.cgt.mentorondemand.trainingdto;

import lombok.Data;

@Data
public class RunningTraining {
	
	private Integer id;
	private String name;
	private String slot;
	private String techName;
	private Integer progress;
	private String startDate;
	private String endDate;
	private Integer amount;
	
	public RunningTraining() {}

	public RunningTraining(Integer id, String name, String slot, String techName, Integer progress,
			String startDate, String endDate, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.slot = slot;
		this.techName = techName;
		this.progress = progress;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount= amount;
	}
	
	
}
