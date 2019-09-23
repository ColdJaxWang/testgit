package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Priv;

public interface PrivDao {
	/**
	 * 通过管理员id获取该用户的所有权限
	 */
	List<Priv> selectPrivsByAid(int aid);
	/**
	 * 通过rid获取所有权限
	 */
	List<Priv> selectPrivsByRid(int rid);
	/**
	 * 获取所有权限名
	 */
	List<Priv> getAllPrivs();
}
