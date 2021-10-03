package com.hp.dao;

import java.util.List;

import com.hp.entity.Order;


public interface OrderDao {
	//添加订单
	void insertO(Order order);
	
	//后台||查询所有订单
	List<Order> selectALLO();
}
