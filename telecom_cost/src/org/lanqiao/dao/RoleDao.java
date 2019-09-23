package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Role;

public interface RoleDao {

	/**
	 * 根据管理员id查询对应所有角色
	 */
	List<Role> selectRnameById(int aid);
	/**
	 * 获取所有角色
	 */
	List<Role> selectAllRoles();
	/**
	 * 添加角色
	 */
	int addRole(Role role);
	/**
	 * 添加角色关联权限
	 */
	int insertRolePrivs(Role role);
	/**
	 * 删除角色关联权限
	 */
	int deleteRolePrivs(int rid);
	/**
	 * 删除角色
	 */
	int deleteRole(int rid);
	/**
	 * 根据id查询角色
	 * @param id
	 * @return
	 */
	Role selectRoleById(int id);
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	int updateRole(Role role);
}
