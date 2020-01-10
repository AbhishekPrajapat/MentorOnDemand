package com.cgt.mentorondemand.dto;

import java.util.List;

import javax.ws.rs.DefaultValue;

import lombok.Data;

@Data
public class SearchList {
	private List<SearchTraining> search;
	private boolean loggedin;
	
	public SearchList() {}
	public SearchList(List<SearchTraining> search) {
		super();
		this.search = search;
	}
}
