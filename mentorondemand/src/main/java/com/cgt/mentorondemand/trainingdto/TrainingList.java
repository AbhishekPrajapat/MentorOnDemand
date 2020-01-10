package com.cgt.mentorondemand.trainingdto;

import java.util.List;

import com.cgt.mentorondemand.entities.Training;

import lombok.Data;

@Data
public class TrainingList {

	List<Training> trainingList;
	
	public TrainingList() {}

	public TrainingList(List<Training> trainingList) {
		super();
		this.trainingList = trainingList;
	}
	
	
}
