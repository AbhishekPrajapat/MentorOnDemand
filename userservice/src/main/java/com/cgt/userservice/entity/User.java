package com.cgt.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String contact;
	@Column
	private Integer role_id;
	@Column
	private String linkedin_url;
	@Column(nullable = true)
	private Integer year_of_exp;
	@Column
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
