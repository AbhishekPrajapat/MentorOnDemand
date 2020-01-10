package com.cgt.mentorondemand.entities;

import java.sql.Date;


import lombok.Data;

@Data
public class Training {

	private Integer id;

	private Integer mentor_id;

	private Integer user_id;

	private Integer slot_id;

	private Integer tech_id;

	private Integer progress;

	private Date start_date;

	private Date end_date;

	private Integer amount_received;

	private Integer request;

	private Integer isactive;
	
	public Training() {}

	public Training(Integer id, Integer mentor_id, Integer user_id, Integer slot_id, Integer tech_id, Integer progress,
			Date start_date, Date end_date, Integer amount_received, Integer request, Integer isactive) {
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
		this.isactive = isactive;
	}
	
	
}
