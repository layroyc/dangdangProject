package com.hp.service;

import java.util.List;

import com.hp.entity.Order;



public interface OrderService{
	//��Ӷ���
	void addO();
	
	//��̨����ѯ���ж���
	List<Order> queryAll();
}
