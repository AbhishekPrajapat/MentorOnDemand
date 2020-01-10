package com.cgt.training.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Training {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer mentor_id;
	@Column
	private Integer user_id;
	@Column
	private Integer slot_id;
	@Column
	private Integer tech_id;
	@Column
	private Integer progress;
	@Column
	private Date start_date;
	@Column
	private Date end_date;
	@Column
	private Integer amount_received;
	@Column
	private Integer request;

	
	public Training() {}

	public Training(Integer id, Integer mentor_id, Integer user_id, Integer slot_id, Integer tech_id, Integer progress,
			Date start_date, Date end_date, Integer amount_received, Integer request) {
		super();
		this.id = id;
		this.mentor_id = mentor_id;
		this.user_id = user_id;
		this.slot_id = slot_id;
		this.tech_id = tech_id;
		this.progress = progress;
		this.start_date = start_date;
		this.end_date = end_date;
		this.amount_received = amount_received;
		this.request = request;
		
	}
	
	
}
