package com.cgt.mentorskills.dto;

import java.util.List;

import com.cgt.mentorskills.entity.MentorSkills;

import lombok.Data;

@Data
public class MentorSkillList {
	public List<MentorSkills> mentorSkillList;

	public MentorSkillList(List<MentorSkills> mentorSkillList) {
		super();
		this.mentorSkillList = mentorSkillList;
	}
	public MentorSkillList() {}
}
