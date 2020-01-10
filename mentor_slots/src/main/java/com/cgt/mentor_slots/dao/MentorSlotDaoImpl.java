package com.cgt.mentor_slots.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.mentor_slots.entity.MentorSlots;
import com.cgt.mentor_slots.facade.MentorSlotDao;
import com.cgt.mentor_slots.dto.*;
@Repository
@Transactional
public class MentorSlotDaoImpl implements MentorSlotDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public boolean addMentorSlot(MentorSlots mentorslot) {
		this.entity.persist(mentorslot);
		return true;
	}

	@Override
	public boolean deleteMentorSlot(Integer id) {
		MentorSlots mentorslot = this.entity.find(MentorSlots.class, id);
		this.entity.remove(mentorslot);
		return true;
	}

	@Override
	public SlotList getMentorSlotById(Integer mentor_id) {
		List<MentorSlots>  mentorSlotList = this.entity.createQuery("From MentorSlots ms where mentor_id="+mentor_id).getResultList();	
		return (new SlotList(mentorSlotList));
	}

	@Override
	public boolean updateMentorSlot(MentorSlots mentorslots) {
		System.out.println("id is "+mentorslots.getId());
		MentorSlots mentorSlot = this.entity.find(MentorSlots.class, mentorslots.getId());
		mentorSlot.setTime_from(mentorslots.getTime_from());
		mentorSlot.setTime_to(mentorslots.getTime_to());
		this.entity.flush();
		return true;
	}

	@Override
	public MentorSlots getMentorslot(Integer id) {
		MentorSlots mentorSlot = this.entity.find(MentorSlots.class, id);
		return mentorSlot;
	}

}
