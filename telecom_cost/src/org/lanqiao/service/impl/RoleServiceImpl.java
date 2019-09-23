package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.PrivDao;
import org.lanqiao.dao.RoleDao;
import org.lanqiao.dao.impl.PrivDaoImpl;
import org.lanqiao.dao.impl.RoleDaoImpl;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.RoleService;

public class RoleServiceImpl implements RoleService {
	RoleDao roleDao = new RoleDaoImpl();
	PrivDao privDao = new PrivDaoImpl();
	@Override
	public List<Role> getAllRoles() {
		List<Role> lr = roleDao.selectAllRoles();
		for(Role r : lr) {
			List<Priv> lp = privDao.selectPrivsByRid(r.getId());
			r.setLp(lp);
		}
		return lr;
	}
	@Override
	public List<Priv> getAllPrivs() {
		List<Priv> lp = privDao.getAllPrivs();
		return lp;
	}
	@Override
	public boolean addRole(Role role) {
		int rid = roleDao.addRole(role);
		int result = 0;
		if(rid != -1) {
			role.setId(rid);
			result = roleDao.insertRolePrivs(role);
		}
		return (result != 0)?true:false;
	}
	@Override
	public boolean deleteRole(int rid) {
		int deleteRolePrivResult = 0;
		int deleteRoleResult = 0;
		deleteRolePrivResult = roleDao.deleteRolePrivs(rid);
		if(deleteRolePrivResult != 0) {
			deleteRoleResult = roleDao.deleteRole(rid);
		}
		return (deleteRoleResult != 0)?true:false;
	}
	@Override
	public Role getRoleById(int rid) {
		Role role = roleDao.selectRoleById(rid);
		List<Priv> lp = privDao.selectPrivsByRid(rid);
		role.setLp(lp);
		return role;
	}
	@Override
	public boolean updateRole(Role role) {
		int i = roleDao.updateRole(role);
		int j = roleDao.deleteRolePrivs(role.getId());
		int k = roleDao.insertRolePrivs(role);
		
		return i+j+k>=3?true:false;
	}
	@Override
	public List<Role> selectAllRole() {
		List<Role> lr = roleDao.selectAllRoles();
		return lr;
	}

}
