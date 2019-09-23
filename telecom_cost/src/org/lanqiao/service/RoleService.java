package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;

public interface RoleService {
	/**
	 * 获取角色所有权限
	 */
	List<Role> getAllRoles();
	/**
	 * 获取所有权限名
	 */
	List<Priv> getAllPrivs();
	/**
	 * 添加角色
	 */
	boolean addRole(Role role);
	/**
	 * 删除角色
	 */
	boolean deleteRole(int rid);
	/**
	 * 根据id查询角色
	 * @param id
	 * @return
	 */
	Role getRoleById(int id);
	/**
	 * 修改角色
	 */
	boolean updateRole(Role role);
	/**
	 * 自动获取所有权限
	 */
	List<Role> selectAllRole();
}
