package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.Order;

public interface OrderService{
	//��Ӷ���
	void addO();
	
	//��̨����ѯ���ж���
	List<Order> queryAll();
}
