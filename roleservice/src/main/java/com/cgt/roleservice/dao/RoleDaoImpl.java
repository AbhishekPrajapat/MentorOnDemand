package com.cgt.roleservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.roleservice.entity.Roles;
import com.cgt.roleservice.facade.RoleDao;
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public List<Roles> getAllRoles() {
		List<Roles> roleList = this.entity.createQuery("From Roles").getResultList();
		return roleList;
	}

	@Override
	public Roles getRole(Integer id) {
		Roles role = this.entity.find(Roles.class,id);
		return role;
	}

	@Override
	public boolean addRole(Roles role) {
		this.entity.persist(role);		
		return true;
	}

	@Override
	public boolean deleteRole(Integer id) {
		Roles role = this.entity.find(Roles.class,id);
		this.entity.remove(role);
		return true;
	}

}
