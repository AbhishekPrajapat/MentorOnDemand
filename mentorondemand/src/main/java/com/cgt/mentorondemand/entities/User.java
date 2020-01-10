package com.cgt.mentorondemand.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {

	
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String first_name;
	
	private String last_name;
	
	private String contact;
	
	private Integer role_id;
	
	private String linkedin_url;
	
	private Integer year_of_exp;
	
	private Integer isactive;
	
	public User() {}
	
	public User(Integer id, String username, String password, String first_name, String last_name, String contact,
			Integer role_id, String linkedin_url, Integer year_of_exp, Integer isactive) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.contact = contact;
		this.role_id = role_id;
		this.linkedin_url = linkedin_url;
		this.year_of_exp = year_of_exp;
		this.isactive = isactive;
	}
	
	
	
}
