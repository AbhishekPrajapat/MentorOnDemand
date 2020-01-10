package com.cgt.roleservice.facade;

import java.util.List;

import com.cgt.roleservice.entity.Roles;

public interface RoleService {
		public List<Roles> getAllRoles();
		public Roles getRole(Integer id);
		public boolean addRole(Roles role);
		public boolean deleteRole(Integer id);
}
