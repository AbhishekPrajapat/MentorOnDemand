package com.cgt.mentorskills.facade;

import java.util.List;

import com.cgt.mentorskills.dto.MentorSkillList;
import com.cgt.mentorskills.entity.MentorSkills;

public interface MentorSkillService {
	
	public boolean addMentorSkill(MentorSkills mentorSkill);
	public MentorSkillList getSkillOfMentor(Integer mentor_id);
	public MentorSkillList getMentorByTech(Integer technology_id);
	public boolean updateMentorSkill(MentorSkills mentorSkill);
	public boolean deleteMentorSkill(Integer id);
}
