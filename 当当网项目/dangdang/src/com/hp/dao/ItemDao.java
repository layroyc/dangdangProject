package com.hp.dao;

import java.util.List;

import com.hp.entity.Item;


public interface ItemDao {
	//��ӹ�����
	void insertI(Item item);
	
	//��̨�����ݶ���id��ѯÿһ��������||order_id
	List<Item> selectAllI(String oid);
	
}
