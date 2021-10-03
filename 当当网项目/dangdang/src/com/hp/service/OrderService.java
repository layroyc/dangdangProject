package com.hp.service;

import java.util.List;

import com.hp.entity.Order;



public interface OrderService{
	//添加订单
	void addO();
	
	//后台：查询所有订单
	List<Order> queryAll();
}
