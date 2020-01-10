package com.cgt.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.training.dto.BooleanResult;
import com.cgt.training.dto.TrainingList;
import com.cgt.training.entity.Training;
import com.cgt.training.facade.TrainingService;

@RestController
public class TrainingController {

	@Autowired
	private TrainingService trainigService;
	
	@RequestMapping("/addTraining")
	public ResponseEntity<BooleanResult> addTraining(@RequestBody Training training) {
		return new ResponseEntity<>(new BooleanResult(this.trainigService.addTraining(training)),HttpStatus.OK);
	}
		
	@RequestMapping("/deleteTraining/{id}")
	public ResponseEntity<BooleanResult> deleteTraining(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.trainigService.deleteTraining(id)),HttpStatus.OK);
	}
	@RequestMapping("/getTraining/{id}")
	public ResponseEntity<Training> getTraining(@PathVariable Integer id) {
		return new ResponseEntity<>(this.trainigService.getTraining(id),HttpStatus.OK);
	}
	@RequestMapping("/getAllTraining")
	public ResponseEntity<TrainingList> getAllTraining(){
		return new ResponseEntity<>(new TrainingList(this.trainigService.getAllTraining()),HttpStatus.OK);
	}
	
	 @RequestMapping("/updateTraining") 
	 public ResponseEntity<BooleanResult> updateTraining(@RequestBody Training training) { 
		 return new ResponseEntity<>(new BooleanResult(this.trainigService.updateTraining(training)),HttpStatus.OK);
	}
	 @RequestMapping("/getTrainingByMentorId/{mentor_id}")
	 public ResponseEntity<TrainingList> getTrainingByMentorId(@PathVariable Integer mentor_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getTrainingByMentorId(mentor_id)),HttpStatus.OK);

	}
	 @RequestMapping("/getTrainingByTechId/{tech_id}")
	public ResponseEntity<TrainingList> getTrainingByTechId(@PathVariable Integer tech_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getTrainingByTechId(tech_id)),HttpStatus.OK);
	}
	 
	 @RequestMapping("/checkSlot/{slot_id}")
	 public ResponseEntity<BooleanResult> checkSlot(@PathVariable Integer slot_id) {
		 BooleanResult status = new BooleanResult(false);
		 if(this.trainigService.checkSlot(slot_id)){
			 status.setStatus(true);
		 }
		return new ResponseEntity<>(status,HttpStatus.OK);
	 }
	 
	 @RequestMapping("/getRequests/{mentor_id}")
	 public ResponseEntity<TrainingList> getAllRequest(@PathVariable Integer mentor_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getAllRequest(mentor_id)),HttpStatus.OK);
	 }
	 
	 @RequestMapping("/getCompletedTraining/{mentor_id}")
	 public ResponseEntity<TrainingList> getCompletedTraining(@PathVariable Integer mentor_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getCompletedTraining(mentor_id)),HttpStatus.OK);		 
	 }
	 
	 
	 // Student Services
	 
	 @RequestMapping("/getUserPendingRequest/{user_id}")
	 public ResponseEntity<TrainingList> getUserPendingRequest(@PathVariable Integer user_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getUserPendingRequest(user_id)),HttpStatus.OK);		 
	 }
	 
	 @RequestMapping("/getUserRunningTraining/{user_id}")
	 public ResponseEntity<TrainingList> getUserRunningTraining(@PathVariable Integer user_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getUserRunTraining(user_id)),HttpStatus.OK);		 
	 }
	 
	 @RequestMapping("/getUserCompletedTraining/{user_id}")
	 public ResponseEntity<TrainingList> getUserCompletedTraining(@PathVariable Integer user_id){
		 return new ResponseEntity<>(new TrainingList(this.trainigService.getUserCompletedTraining(user_id)),HttpStatus.OK);		 
	 }
	 
	 
	 
}

