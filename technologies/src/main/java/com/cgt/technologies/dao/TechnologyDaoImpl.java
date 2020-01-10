package com.cgt.technologies.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.technologies.entity.Technologies;
import com.cgt.technologies.facade.TechnologyDao;
@Repository
@Transactional
public class TechnologyDaoImpl implements TechnologyDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public boolean addTechnology(Technologies tech) {
		// TODO Auto-generated method stub
		this.entity.persist(tech);
		return true;
	}

	@Override
	public List<Technologies> getAllTech() {
		List<Technologies> tech = this.entity.createQuery("From Technologies tech where tech.isactive=1").getResultList();
		return tech;
	}

	@Override
	public Technologies getTech(Integer id) {
		Technologies tech = this.entity.find(Technologies.class, id);
		return tech;
	}

	@Override
	public boolean deleteTech(Integer id) {
		Technologies tech = this.entity.find(Technologies.class, id);
		tech.setIsactive(0);
		this.entity.flush();
		return true;
	}

}
