package org.lanqiao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.AdminDao;
import org.lanqiao.dao.PrivDao;
import org.lanqiao.dao.RoleDao;
import org.lanqiao.dao.impl.AdminDaoImpl;
import org.lanqiao.dao.impl.PrivDaoImpl;
import org.lanqiao.dao.impl.RoleDaoImpl;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao = new AdminDaoImpl();
	PrivDao privDao = new PrivDaoImpl();
	RoleDao roleDao = new RoleDaoImpl();
	@Override
	public Admin checkUsernameAndPwd(Admin admin) {
		//查询用户表和密码到tc_admin表中
		Admin admin2 = adminDao.selectAdminByAcnameAndApwd(admin);
		//假如登录成功，继续获取该管理员的所有权限到tc_priv表
		if(admin2 != null) {
			List<Priv> lp = privDao.selectPrivsByAid(admin2.getId());
			List<Role> lr = roleDao.selectRnameById(admin2.getId());
			admin2.setLp(lp);
			admin2.setLr(lr);
		}
		
		return admin2;
	}
	@Override
	public boolean checkPwdUpdateSuccess(Admin admin) {
		int result = adminDao.updateAdminPwd(admin);
		return (result != 0)?true:false;
	}
	@Override
	public boolean updateAdminInfo(Admin admin) {
		int result = adminDao.updateAdminInfo(admin);
		return (result != 0)?true:false;
	}
	@Override
	public List<Admin> selectAllAdminInfo() {
		List<Admin> la = new ArrayList<>();
		la = adminDao.selectAllAdminInfo();
		for(Admin admin : la) {
			List<Role> lr = roleDao.selectRnameById(admin.getId());
			admin.setLr(lr);
		}
		return la;
	}
	@Override
	public boolean addAdmin(Admin admin, List<Role> lr) {
		int aid = adminDao.addAdmin(admin);
		int result = 0;
		if(aid != -1) {
			result = adminDao.addAdminRole(aid, lr);
		}
		return (result != 0)?true:false;
	}

}
