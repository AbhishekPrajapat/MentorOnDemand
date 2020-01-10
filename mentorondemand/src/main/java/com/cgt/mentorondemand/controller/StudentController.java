package com.cgt.mentorondemand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.mentorondemand.dto.BooleanResult;
import com.cgt.mentorondemand.entities.Training;
import com.cgt.mentorondemand.facade.MentorOnDemandService;
import com.cgt.mentorondemand.trainingdto.CompletedTrainingList;
import com.cgt.mentorondemand.trainingdto.RequestTrainingList;
import com.cgt.mentorondemand.trainingdto.RunningTrainingList;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private MentorOnDemandService service;
	
	@RequestMapping("/sendRequestForTraining/{user_id}/{tech_id}/{mentor_id}/{slot_id}")
	public ResponseEntity<BooleanResult> sendRequestForTraining(@PathVariable Integer user_id ,@PathVariable Integer tech_id,
																	@PathVariable Integer mentor_id,@PathVariable Integer slot_id){
		return new ResponseEntity<>(this.service.sendRequest(user_id, tech_id, mentor_id, slot_id),HttpStatus.OK);
	}
	
	@RequestMapping("/getUserCompletedTraining/{user_id}")
	public ResponseEntity<CompletedTrainingList> getCompletedTraining(@PathVariable Integer user_id){
		return new ResponseEntity<>(new CompletedTrainingList(this.service.getUserCompletedTraining(user_id)),HttpStatus.OK);
	}
	
	@RequestMapping("/getUserRunningTraining/{user_id}")
	public ResponseEntity<RunningTrainingList> getAllRunningTraining(@PathVariable Integer user_id){
		return new ResponseEntity<>(new RunningTrainingList(this.service.getUserRunningTraining(user_id)),HttpStatus.OK);		
	}
	
	@RequestMapping("/getUserPendingRequest/{user_id}")
	public ResponseEntity<RequestTrainingList> getALLPendingRequest(@PathVariable Integer user_id){
		return new ResponseEntity<>(new RequestTrainingList(this.service.getPendingRequest(user_id)),HttpStatus.OK);		
	}	
}
