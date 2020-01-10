package com.cgt.mentorondemand.mentordto;

import java.util.List;

import com.cgt.mentorondemand.entities.MentorSlots;

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
