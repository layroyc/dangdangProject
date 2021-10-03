package com.baizhi.xzy.entity;

import java.io.Serializable;
/*
 * 后台系统
 * 管理员表（u_manage）
 */
public class Admin implements Serializable{
	private Integer id;
	private String username;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	public Admin(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
