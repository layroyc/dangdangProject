package com.baizhi.xzy.entity;

import java.io.Serializable;

public class Address implements Serializable{
	private String id;
	private String zip;
	private String name;
	private String address;
	private String telphone; 
	private String u_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", zip=" + zip + ", name=" + name
				+ ", address=" + address + ", telphone=" + telphone + ", u_id="
				+ u_id + "]";
	}
	public Address(String id, String zip, String name, String address,
			String telphone, String u_id) {
		super();
		this.id = id;
		this.zip = zip;
		this.name = name;
		this.address = address;
		this.telphone = telphone;
		this.u_id = u_id;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
}
