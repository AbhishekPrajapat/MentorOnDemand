package com.cgt.mentorondemand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.mentorondemand.dto.BooleanResult;
import com.cgt.mentorondemand.entities.MentorSlots;
import com.cgt.mentorondemand.facade.MentorOnDemandService;
import com.cgt.mentorondemand.mentordto.SlotList;
import com.cgt.mentorondemand.trainingdto.CompletedTraining;
import com.cgt.mentorondemand.trainingdto.CompletedTrainingList;
import com.cgt.mentorondemand.trainingdto.RequestTrainingList;
import com.cgt.mentorondemand.trainingdto.RunningTrainingList;
import com.cgt.mentorondemand.trainingdto.TrainingList;
import com.cgt.mentorondemand.userdto.UserProfile;

@RestController
@RequestMapping("/mentor")
public class MentorController {
	
	@Autowired
	private MentorOnDemandService service;
	
	@RequestMapping("/getAllRequest/{mentor_id}")
	public ResponseEntity<RequestTrainingList> getALLRequest(@PathVariable Integer mentor_id){
		return new ResponseEntity<>(new RequestTrainingList(this.service.getAllRequest(mentor_id)),HttpStatus.OK);		
	}
	
	@RequestMapping("/getAllRunningTraining/{mentor_id}")
	public ResponseEntity<RunningTrainingList> getAllRunningTraining(@PathVariable Integer mentor_id){
		return new ResponseEntity<>(new RunningTrainingList(this.service.getAllRunningTraining(mentor_id)),HttpStatus.OK);		
	}
	
	@RequestMapping("/getMentorSlot/{mentor_id}")
	public ResponseEntity<SlotList> getMentorSlot(@PathVariable Integer mentor_id){
		return new ResponseEntity<>(this.service.getAllMentorSlots(mentor_id),HttpStatus.OK);		
	}
	
	@RequestMapping("/updateMentorSlot")
	public ResponseEntity<BooleanResult> updateMentorSlot(@RequestBody MentorSlots slot){
		return new ResponseEntity<>(this.service.updateMentorSlots(slot),HttpStatus.OK);		
	}
	
	@RequestMapping("/addMentorSlot")
	public ResponseEntity<BooleanResult> addMentorSlot(@RequestBody MentorSlots slot){
		return new ResponseEntity<>(this.service.addSlot(slot),HttpStatus.OK);		
	}
	
	@RequestMapping("/getCompletedTraining/{mentor_id}")
	public ResponseEntity<CompletedTrainingList> getCompletedTraining(@PathVariable Integer mentor_id){
		return new ResponseEntity<>(new CompletedTrainingList(this.service.completedTraining(mentor_id)),HttpStatus.OK);
	}
	
	@RequestMapping("/editProfile/{id}")
	public ResponseEntity<UserProfile> editProfile(@PathVariable Integer id){
		return new ResponseEntity<>(this.service.editUserProfile(id),HttpStatus.OK);		
	}
	
	@RequestMapping("/updateMentorProfile")
	public ResponseEntity<BooleanResult> updateMentorProfile(@RequestBody UserProfile profile){
		return new ResponseEntity<>(this.service.updateMentorProfile(profile),HttpStatus.OK);
	}

}
