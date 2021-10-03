package com.baizhi.xzy.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private String id;
	private String email;
	private String username;
	private String password;
	private String status;  //×´Ì¬
	private String CDK; //¼¤»îÂë
	private Date regdate; //×¢²áÊ±¼ä
	private String salt; //ÑÎ
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCDK() {
		return CDK;
	}
	public void setCDK(String cDK) {
		CDK = cDK;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", status=" + status + ", CDK="
				+ CDK + ", regdate=" + regdate + ", salt=" + salt + "]";
	}
	public User(String id, String email, String username, String password,
			String status, String cDK, Date regdate, String salt) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
		CDK = cDK;
		this.regdate = regdate;
		this.salt = salt;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
