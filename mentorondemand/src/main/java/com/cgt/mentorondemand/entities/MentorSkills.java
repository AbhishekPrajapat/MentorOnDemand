package com.cgt.mentorondemand.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

public class MentorSkills {

	private Integer id;
	
	private Integer mentor_id;
	
	private Integer technology_id;
	
	private String toc;
	
	private String prerequisites;
	
	private double fee;
	
	public MentorSkills() {}

	public MentorSkills(Integer id, Integer mentor_id, Integer technology_id, String toc, String prerequisites,
			double fee) {
		super();
		this.id = id;
		this.mentor_id = mentor_id;
		this.technology_id = technology_id;
		this.toc = toc;
		this.prerequisites = prerequisites;
		this.fee = fee;
	}	
}

