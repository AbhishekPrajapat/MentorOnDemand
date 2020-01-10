package com.cgt.mentorondemand.trainingdto;

import java.util.List;

import lombok.Data;
@Data
public class CompletedTrainingList {
	
	private List<CompletedTraining> completeTraining;
	
	public CompletedTrainingList() {}

	public CompletedTrainingList(List<CompletedTraining> completeTraining) {
		super();
		this.completeTraining = completeTraining;
	}
}
