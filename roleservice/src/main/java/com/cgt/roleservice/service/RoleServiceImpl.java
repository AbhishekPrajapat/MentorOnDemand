package com.cgt.roleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.roleservice.entity.Roles;
import com.cgt.roleservice.facade.RoleDao;
import com.cgt.roleservice.facade.RoleService;
@Repository
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Roles> getAllRoles() {
		return this.roleDao.getAllRoles();
	}

	@Override
	public Roles getRole(Integer id) {
		return this.roleDao.getRole(id);
	}

	@Override
	public boolean addRole(Roles role) {
		return this.roleDao.addRole(role);
	}

	@Override
	public boolean deleteRole(Integer id) {
		return this.roleDao.deleteRole(id);
	}

}
