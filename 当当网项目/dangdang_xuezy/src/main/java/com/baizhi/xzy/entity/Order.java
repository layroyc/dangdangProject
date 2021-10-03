package com.baizhi.xzy.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * 订单表
 */
public class Order implements Serializable{
	private String id;
	private String  order_number;  //订单编号
	private Date  order_times;     //订单时间
	private Double total_price;    //总价
	private String  status;        //订单状态
	private String  name;          //收货人姓名
	private String   address;      //地址
	private String   user_id;      //用户id
	private String  addr_id;       //地址id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public Date getOrder_times() {
		return order_times;
	}
	public void setOrder_times(Date order_times) {
		this.order_times = order_times;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_number=" + order_number
				+ ", order_times=" + order_times + ", total_price="
				+ total_price + ", status=" + status + ", name=" + name
				+ ", address=" + address + ", user_id=" + user_id
				+ ", addr_id=" + addr_id + "]";
	}
	public Order(String id, String order_number, Date order_times,
			Double total_price, String status, String name, String address,
			String user_id, String addr_id) {
		super();
		this.id = id;
		this.order_number = order_number;
		this.order_times = order_times;
		this.total_price = total_price;
		this.status = status;
		this.name = name;
		this.address = address;
		this.user_id = user_id;
		this.addr_id = addr_id;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}
