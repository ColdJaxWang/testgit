package org.lanqiao.entity;

import java.sql.Date;
import java.util.List;

public class Admin {
	private int id;
	private String aname;
	private String apwd;
	private String acname;
	private String atel;
	private String aemail;
	private String eimg;
	
	private Date createTime;
	private String createUser;
	private Date updateTime;
	private String updateUser;
	
	private String by001;
	private String by002;
	private int by003;
	private Date by004;
	
	private List<Priv> lp;	//该用户的权限集合
	private List<Role> lr;  //获取该用户的所有角色
	
	public String getLr_String() {
		String lr_String = "";
		if(lr != null) {
			for(int i = 0; i < lr.size(); i++) {
				if(i == lr.size()-1)
					lr_String += lr.get(i).getRname();
				else
					lr_String += lr.get(i).getRname()+"，";
			}
		}
		return lr_String;
	}
	
	public Admin() {
	}
	
	public Admin(String acname, String apwd) {
		this.acname = acname;
		this.apwd = apwd;
	}
	
	public Admin(int id, String acname, String aname, String atel, String aemail) {
		this.id = id;
		this.acname = acname;
		this.aname = aname;
		this.atel = atel;
		this.aemail = aemail;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getEimg() {
		return eimg;
	}
	public void setEimg(String eimg) {
		this.eimg = eimg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getBy001() {
		return by001;
	}
	public void setBy001(String by001) {
		this.by001 = by001;
	}
	public String getBy002() {
		return by002;
	}
	public void setBy002(String by002) {
		this.by002 = by002;
	}
	public int getBy003() {
		return by003;
	}
	public void setBy003(int by003) {
		this.by003 = by003;
	}
	public Date getBy004() {
		return by004;
	}
	public void setBy004(Date by004) {
		this.by004 = by004;
	}
	public List<Priv> getLp() {
		return lp;
	}
	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}

	public List<Role> getLr() {
		return lr;
	}

	public void setLr(List<Role> lr) {
		this.lr = lr;
	}

}
