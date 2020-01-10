package com.cgt.mentorskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.mentorskills.dto.MentorSkillList;
import com.cgt.mentorskills.entity.MentorSkills;
import com.cgt.mentorskills.facade.MentorSkillDao;
import com.cgt.mentorskills.facade.MentorSkillService;
@Repository
@Transactional
public class MentorSkillsServiceImpl implements MentorSkillService {
	@Autowired
	private MentorSkillDao mentorDao;
	
	@Override
	public boolean addMentorSkill(MentorSkills mentorSkill) {
		return this.mentorDao.addMentorSkill(mentorSkill);
	}

	@Override
	public MentorSkillList getSkillOfMentor(Integer mentor_id) {
		return this.mentorDao.getSkillOfMentor(mentor_id);
	}

	@Override
	public MentorSkillList getMentorByTech(Integer technology_id) {
		return this.mentorDao.getMentorByTech(technology_id);
	}

	@Override
	public boolean updateMentorSkill(MentorSkills mentorSkill) {
		return this.mentorDao.updateMentorSkill(mentorSkill);		
	}

	@Override
	public boolean deleteMentorSkill(Integer id) {
		return this.mentorDao.deleteMentorSkill(id);
	}

}
