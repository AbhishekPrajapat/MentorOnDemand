package com.cgt.mentorskills.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mentorskills")
public class MentorSkills {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer mentor_id;
	@Column
	private Integer technology_id;
	@Column
	private String toc;
	@Column
	private String prerequisites;
	@Column
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

