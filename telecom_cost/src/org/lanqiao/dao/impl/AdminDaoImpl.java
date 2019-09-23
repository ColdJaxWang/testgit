package org.lanqiao.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.AdminDao;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Role;
import org.lanqiao.util.JDBCUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin selectAdminByAcnameAndApwd(Admin admin) {
		Admin admin2 = null;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tc_admin where acname = ? and apwd = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getAcname());
			ps.setString(2, admin.getApwd());
			rs = ps.executeQuery();
			if(rs.next()) {
				admin2 = new Admin();
				admin2.setId(rs.getInt("id"));
				admin2.setAname(rs.getString("aname"));
				admin2.setAcname(rs.getString("acname"));
				admin2.setApwd(rs.getString("apwd"));
				admin2.setAemail(rs.getString("aemail"));
				admin2.setAtel(rs.getString("atel"));
				admin2.setBy001(rs.getString("by001"));
				admin2.setCreateTime(rs.getDate("createtime"));
			}
		}catch(SQLException e) {
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
		return admin2;
	}

	@Override
	public int updateAdminPwd(Admin admin) {
		int result = 0;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update tc_admin set apwd=? where id =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getApwd());
			ps.setInt(2, admin.getId());
			result = ps.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
		return result;
	}

	@Override
	public int updateAdminInfo(Admin admin) {
		int result = 0;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update tc_admin set aname=?,atel=?,aemail=?,updateuser=?,updatetime=? where id =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getAname());
			ps.setString(2, admin.getAtel());
			ps.setString(3, admin.getAemail());
			ps.setString(4, admin.getAcname());
			ps.setDate(5, new Date(new java.util.Date().getTime()));
			ps.setInt(6, admin.getId());
			result = ps.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
		return result;
	}

	@Override
	public List<Admin> selectAllAdminInfo() {
		
		List<Admin> la = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tc_admin ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAname(rs.getString("aname"));
				admin.setAcname(rs.getString("acname"));
				admin.setApwd(rs.getString("apwd"));
				admin.setAemail(rs.getString("aemail"));
				admin.setAtel(rs.getString("atel"));
				admin.setBy001(rs.getString("by001"));
				admin.setCreateTime(rs.getDate("createtime"));
				la.add(admin);
			}
		}catch(SQLException e) {
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
		return la;
	}

	@Override
	public int addAdmin(Admin admin) {
		int id = -1;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tc_admin (aname, apwd, acname, atel, aemail, createtime) values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, admin.getAname());
			ps.setString(2, admin.getApwd());
			ps.setString(3, admin.getAcname());
			ps.setString(4, admin.getAtel());
			ps.setString(5, admin.getAemail());
			ps.setDate(6, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
			//获取主键值
			rs = ps.getGeneratedKeys();
			if(rs.next()) id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return id;
	}

	@Override
	public int addAdminRole(int aid, List<Role> lr) {
		int result = 0;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tc_admin_role (aid, rid) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			for(Role role : lr) {
				ps.setInt(1, aid);
				ps.setInt(2, role.getId());
				result += ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

}
