package com.cgt.mentor_slots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.mentor_slots.dto.SlotList;
import com.cgt.mentor_slots.entity.MentorSlots;
import com.cgt.mentor_slots.facade.MentorSlotDao;
import com.cgt.mentor_slots.facade.MentorSlotService;
@Repository
@Transactional
public class MentorSlotServiceImpl implements MentorSlotService {

	@Autowired
	private MentorSlotDao mentorSlotDao;
	@Override
	public boolean addMentorSlot(MentorSlots mentorslot) {
		return this.mentorSlotDao.addMentorSlot(mentorslot);
	}

	@Override
	public boolean deleteMentorSlot(Integer id) {
		return this.mentorSlotDao.deleteMentorSlot(id);
	}

	@Override
	public SlotList getMentorSlotById(Integer mentor_id) {
		return this.mentorSlotDao.getMentorSlotById(mentor_id);
	}

	@Override
	public boolean updateMentorSlot(MentorSlots mentorslot) {
		return this.mentorSlotDao.updateMentorSlot(mentorslot);
	}

	@Override
	public MentorSlots getMentorslot(Integer id) {
		return this.mentorSlotDao.getMentorslot(id);
	}

}
