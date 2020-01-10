package com.cgt.mentorskills.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.mentorskills.dto.MentorSkillList;
import com.cgt.mentorskills.entity.MentorSkills;
import com.cgt.mentorskills.facade.MentorSkillDao;

@Repository
@Transactional
public class MentorSkillDaoImpl implements MentorSkillDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public boolean addMentorSkill(MentorSkills mentorSkill) {
		this.entity.persist(mentorSkill);
		return true;
	}

	@Override
	public boolean updateMentorSkill(MentorSkills mentorSkill) {
		MentorSkills mentorSkills = this.entity.find(MentorSkills.class,mentorSkill.getId());
		mentorSkills.setToc(mentorSkill.getToc());
		mentorSkills.setFee(mentorSkill.getFee());
		mentorSkills.setPrerequisites(mentorSkill.getPrerequisites());
		this.entity.flush();
		return true;
	}

	@Override
	public MentorSkillList getSkillOfMentor(Integer mentor_id) {
		List<MentorSkills> mentorList = this.entity.createQuery("From MentorSkills ms where ms.mentor_id="+mentor_id).getResultList();
		return new MentorSkillList(mentorList);
	}

	@Override
	public MentorSkillList  getMentorByTech(Integer technology_id) {
		List<MentorSkills> techList = this.entity.createQuery("From MentorSkills ms where ms.technology_id="+technology_id).getResultList();
		return new MentorSkillList(techList);
	}

	@Override
	public boolean deleteMentorSkill(Integer id) {
		MentorSkills mentorSkill = this.entity.find(MentorSkills.class, id);
		this.entity.remove(mentorSkill);
		return true;
	}

}
