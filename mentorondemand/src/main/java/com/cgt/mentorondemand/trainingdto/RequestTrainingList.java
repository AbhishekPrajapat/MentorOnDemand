package com.cgt.mentorondemand.trainingdto;

import java.util.List;

import lombok.Data;

@Data
public class RequestTrainingList {
	
	private List<RequestTraining> requestedList;
	
	public RequestTrainingList() {}

	public RequestTrainingList(List<RequestTraining> requestedList) {
		super();
		this.requestedList = requestedList;
	}
	
}
