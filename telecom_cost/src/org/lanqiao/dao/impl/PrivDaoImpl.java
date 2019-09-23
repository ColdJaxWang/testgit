package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.PrivDao;
import org.lanqiao.entity.Priv;
import org.lanqiao.util.JDBCUtil;

public class PrivDaoImpl implements PrivDao {

	@Override
	public List<Priv> selectPrivsByAid(int aid) {
		List<Priv> lp = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id, class, url from tc_priv where id in"
						+ " (select pid from tc_role_priv where rid in"
							+ "(select rid from tc_admin_role where aid = ?))";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			while(rs.next()) {
				Priv priv = new Priv();
				priv.setPid(rs.getInt("id"));
				priv.setPclass(rs.getString("class"));
				priv.setPurl(rs.getString("url"));
				lp.add(priv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return lp;
	}

	@Override
	public List<Priv> selectPrivsByRid(int rid) {
		List<Priv> lp = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tc_priv where id in"
				+ "(select pid from tc_role_priv where rid = ? )and state = 0 ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			rs = ps.executeQuery();
			while(rs.next()) {
				Priv priv = new Priv();
				priv.setPid(rs.getInt("id"));
				priv.setPclass(rs.getString("class"));
				priv.setPurl(rs.getString("url"));
				priv.setName(rs.getString("name"));
				priv.setState(rs.getInt("state"));
				lp.add(priv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return lp;
	}

	@Override
	public List<Priv> getAllPrivs() {
		List<Priv> lp = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tc_priv where id in"
				+ "(select pid from tc_role_priv) ";	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Priv priv = new Priv();
				priv.setPid(rs.getInt("id"));
				priv.setPclass(rs.getString("class"));
				priv.setPurl(rs.getString("url"));
				priv.setName(rs.getString("name"));
				priv.setState(rs.getInt("state"));
				lp.add(priv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return lp;
	}

}
