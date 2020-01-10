package com.cgt.technologies.facade;

import java.util.List;

import com.cgt.technologies.entity.Technologies;

public interface TechnologyDao {
	
	public boolean addTechnology(Technologies tech);
	public List<Technologies> getAllTech();
	public Technologies getTech(Integer id);
	public boolean deleteTech(Integer id);
}
