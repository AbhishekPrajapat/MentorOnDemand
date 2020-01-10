package com.cgt.mentorondemand.entities;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
public class MentorSlots {

	private Integer id;

	private Integer mentor_id;

	private String time_from;

	private String time_to;
	public MentorSlots() {}
}
