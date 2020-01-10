package com.cgt.mentorondemand.userdto;

import lombok.Data;

@Data
public class UserProfile {

	private Integer id;
	private String first_name;
	private String last_name;
	private String contact;
	private String linkedin_url;
	private Integer year_of_exp;
	
	public UserProfile() {}

	public UserProfile(Integer id, String first_name, String last_name, String contact, String linkedin_url,
			Integer year_of_exp) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.contact = contact;
		this.linkedin_url = linkedin_url;
		this.year_of_exp = year_of_exp;
	}
}
