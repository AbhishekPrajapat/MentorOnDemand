package com.cgt.roleservice.facade;

import java.util.List;

import com.cgt.roleservice.entity.Roles;

public interface RoleDao {
	public List<Roles> getAllRoles();
	public Roles getRole(Integer Id);
	public boolean addRole(Roles role);
	public boolean deleteRole(Integer Id);
}
