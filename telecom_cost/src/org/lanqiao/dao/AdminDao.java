package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Role;

public interface AdminDao {
	/**
	 * 根据用户账号密码查询用户
	 * @param admin
	 * @return
	 */
	Admin selectAdminByAcnameAndApwd(Admin admin);
	/**
	 * 修改密码
	 */
	int updateAdminPwd(Admin admin);
	/**
	 * 修改用户信息
	 */
	int updateAdminInfo(Admin admin);
	/**
	 * 获取所有用户信息
	 */
	List<Admin> selectAllAdminInfo();
	
	/**
	 * 添加角色
	 * @param admin
	 * @return
	 */
	int addAdmin(Admin admin);
	/**
	 * 添加用户角色关联
	 * @param aid
	 * @return
	 */
	int addAdminRole(int aid, List<Role> lr);
}
