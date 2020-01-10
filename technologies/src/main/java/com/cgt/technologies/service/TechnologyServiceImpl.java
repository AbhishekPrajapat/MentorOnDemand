package com.cgt.technologies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.cgt.technologies.entity.Technologies;
import com.cgt.technologies.facade.TechnologyDao;
import com.cgt.technologies.facade.TechnologyService;
@Repository
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyDao technodao;
	@Override
	public boolean addTechnology(Technologies tech) {
		return this.technodao.addTechnology(tech);
	}

	@Override
	public List<Technologies> getAllTech() {
		return this.technodao.getAllTech();
	}

	@Override
	public Technologies getTech(Integer id) {
		return this.technodao.getTech(id);
	}

	@Override
	public boolean deleteTech(Integer id) {
		return this.technodao.deleteTech(id);
	}

}
