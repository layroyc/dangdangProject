package com.baizhi.xzy.dao;

import java.util.List;

import com.baizhi.xzy.entity.Order;

public interface OrderDao {
	//��Ӷ���
	void insertO(Order order);
	
	//��̨||��ѯ���ж���
	List<Order> selectALLO();
}
