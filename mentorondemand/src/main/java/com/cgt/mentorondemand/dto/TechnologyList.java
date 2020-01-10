package com.cgt.mentorondemand.dto;

import java.util.List;

import com.cgt.mentorondemand.entities.Technologies;

public class TechnologyList {
	public List<Technologies> techList;
	
	public TechnologyList() {}

	@Override
	public String toString() {
		return "TechnologyList [techList=" + techList + "]";
	}
	
	
}
