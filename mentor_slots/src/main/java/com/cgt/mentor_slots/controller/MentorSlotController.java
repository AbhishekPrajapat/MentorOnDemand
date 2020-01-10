package com.cgt.mentor_slots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.mentor_slots.dto.BooleanResult;
import com.cgt.mentor_slots.dto.SlotList;
import com.cgt.mentor_slots.entity.MentorSlots;
import com.cgt.mentor_slots.facade.MentorSlotService;


@RestController
public class MentorSlotController {
	
	@Autowired
	private MentorSlotService mentorSlotService;
	
	@RequestMapping("/addMentorSlot")
	public ResponseEntity<BooleanResult> addMentorSlot(@RequestBody MentorSlots mentorslot) {
		return new ResponseEntity<>(new BooleanResult(this.mentorSlotService.addMentorSlot(mentorslot)),HttpStatus.OK);
	}
	
	@RequestMapping("/deleteMentorSlot/{id}")
	public ResponseEntity<BooleanResult> deleteMentorSlot(@PathVariable Integer id) {
		return new ResponseEntity<>(new BooleanResult(this.mentorSlotService.deleteMentorSlot(id)),HttpStatus.OK);
	}
	@RequestMapping("/getSlotByMentorId/{mentor_id}")
	public SlotList getMentorSlotById(@PathVariable Integer mentor_id){
		return this.mentorSlotService.getMentorSlotById(mentor_id);
	}
	@RequestMapping("/updateMentorSlot")
	public ResponseEntity<BooleanResult> updateMentorSlot(@RequestBody MentorSlots mentorslot) {
		return new ResponseEntity<>(new BooleanResult(this.mentorSlotService.updateMentorSlot(mentorslot)),HttpStatus.OK);
	}
	@RequestMapping("/getMentorslot/{id}")
	public ResponseEntity<MentorSlots> getMentorslot(@PathVariable Integer id) {
		return new ResponseEntity<>(this.mentorSlotService.getMentorslot(id),HttpStatus.OK);
	}

}
