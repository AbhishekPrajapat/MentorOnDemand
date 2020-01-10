package com.cgt.mentorondemand.trainingdto;

import java.util.List;

import lombok.Data;

@Data
public class RunningTrainingList {
	
	private List<RunningTraining> runningTraining;
	
	public RunningTrainingList() {}

	public RunningTrainingList(List<RunningTraining> runningTraining) {
		super();
		this.runningTraining = runningTraining;
	}
}
