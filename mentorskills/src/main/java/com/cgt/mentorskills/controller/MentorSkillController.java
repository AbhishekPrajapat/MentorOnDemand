package com.cgt.mentorskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.mentorskills.dto.BooleanResult;
import com.cgt.mentorskills.dto.MentorSkillList;
import com.cgt.mentorskills.entity.MentorSkills;
import com.cgt.mentorskills.facade.MentorSkillService;

@RestController
public class MentorSkillController {
	
	@Autowired
	private MentorSkillService mentorService;
	
	@RequestMapping("/addMentorSkill")
	public ResponseEntity<BooleanResult> addMentorSkill(@RequestBody MentorSkills mentorSkill) {
		return new ResponseEntity<>(new BooleanResult(this.mentorService.addMentorSkill(mentorSkill)),HttpStatus.OK); 
	}
	
	@RequestMapping("/getSkillsByMentor/{mentor_id}")
	public ResponseEntity<MentorSkillList> getSkillofMentor(@PathVariable Integer mentor_id){
		return new ResponseEntity<>(this.mentorService.getSkillOfMentor(mentor_id),HttpStatus.OK);
	}
	
	@RequestMapping("/getMentorByTech/{technology_id}")
	public ResponseEntity<MentorSkillList> getMentorbyTech(@PathVariable Integer technology_id){
		return new ResponseEntity<>(this.mentorService.getMentorByTech(technology_id),HttpStatus.OK);
	}
	
	@RequestMapping("/updateMentorSkill")
	public ResponseEntity<BooleanResult> updateMentorSkill(@RequestBody MentorSkills mentorSkill) {
		return new ResponseEntity<>(new BooleanResult(this.mentorService.updateMentorSkill(mentorSkill)),HttpStatus.OK);
	}
	
	@RequestMapping("/deleteMentorSkill/{id}")
	public ResponseEntity<BooleanResult> deleteMentorSkill(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.mentorService.deleteMentorSkill(id)),HttpStatus.OK);
	}
	
}
