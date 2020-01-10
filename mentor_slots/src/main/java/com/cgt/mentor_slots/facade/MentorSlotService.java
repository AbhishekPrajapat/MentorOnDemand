package com.cgt.mentor_slots.facade;

import java.util.List;

import com.cgt.mentor_slots.dto.SlotList;
import com.cgt.mentor_slots.entity.MentorSlots;

public interface MentorSlotService {
	
	public boolean addMentorSlot(MentorSlots mentorslot);
	public boolean deleteMentorSlot(Integer id);
	public SlotList  getMentorSlotById(Integer mentor_id);
	public boolean updateMentorSlot(MentorSlots mentorslot);
	public MentorSlots getMentorslot(Integer id);

}
