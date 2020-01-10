package com.cgt.mentorondemand.dto;

import java.util.List;

import com.cgt.mentorondemand.entities.MentorSkills;

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
