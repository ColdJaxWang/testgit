package org.lanqiao.entity;

import java.util.List;

public class Role {
	private int id;
	private String rname;
	private List<Priv> lp;
	private String by001;//头像地址
	
	public String getPrivs() {
		String s = "";
		for(int i = 0; i < lp.size(); i++) {
			if(i == lp.size()-1)
				s += lp.get(i).getName();
			else
				s += lp.get(i).getName() + "，";
		}
		return s;
	}
	
	public Role() {
	}
	
	public Role(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public List<Priv> getLp() {
		return lp;
	}
	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}

	public String getBy001() {
		return by001;
	}

	public void setBy001(String by001) {
		this.by001 = by001;
	}
}
