package com.hp.dao;

import java.util.List;

import com.hp.entity.Order;


public interface OrderDao {
	//��Ӷ���
	void insertO(Order order);
	
	//��̨||��ѯ���ж���
	List<Order> selectALLO();
}
