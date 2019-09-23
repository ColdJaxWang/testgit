package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Role;

public interface AdminService {
	/**
	 * 检查用户名和密码
	 * @param admin
	 * @return
	 */
	Admin checkUsernameAndPwd(Admin admin);
	/**
	 * 检查用户密码修改是否成功
	 */
	boolean checkPwdUpdateSuccess(Admin admin);
	/**
	 * 修改用户信息
	 */
	boolean updateAdminInfo(Admin admin);
	/**
	 * 获取所有用户信息
	 */
	List<Admin> selectAllAdminInfo();
	/**
	 * 添加用户
	 */
	boolean addAdmin(Admin admin, List<Role> lr);
}
