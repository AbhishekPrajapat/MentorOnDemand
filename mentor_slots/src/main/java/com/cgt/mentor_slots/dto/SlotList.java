package com.cgt.mentor_slots.dto;

import java.util.List;

import com.cgt.mentor_slots.entity.MentorSlots;

import lombok.Data;

@Data
public class SlotList {

	private List<MentorSlots> mentorSlots;

	public SlotList(List<MentorSlots> mentorSlots) {
		super();
		this.mentorSlots = mentorSlots;
	}
	public SlotList() {}
	
}
