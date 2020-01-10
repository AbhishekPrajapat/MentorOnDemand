package com.cgt.training.dto;

import java.util.List;

import com.cgt.training.entity.Training;

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
