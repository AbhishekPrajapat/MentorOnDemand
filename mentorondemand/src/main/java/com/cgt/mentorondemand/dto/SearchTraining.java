package com.cgt.mentorondemand.dto;

import lombok.Data;

@Data
public class SearchTraining {
	private Integer tech_id;
	private Integer mentor_id;
	private Integer slot_id;
	private String TechName;
	private String MentorName;
	private Integer exp_years;
	private String toc;
	private String preque;
	private String linkedIn;
	private String slot;
	private double fee;
	
	public SearchTraining() {}

	public SearchTraining(Integer tech_id, Integer mentor_id, Integer slot_id, String techName, String mentorName,
			Integer exp_years, String toc, String preque, String linkedIn, String slot, double fee) {
		super();
		this.tech_id = tech_id;
		this.mentor_id = mentor_id;
		this.slot_id = slot_id;
		TechName = techName;
		MentorName = mentorName;
		this.exp_years = exp_years;
		this.toc = toc;
		this.preque = preque;
		this.linkedIn = linkedIn;
		this.slot = slot;
		this.fee = fee;
	}
}
