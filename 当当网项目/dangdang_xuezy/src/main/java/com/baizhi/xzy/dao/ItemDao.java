package com.baizhi.xzy.dao;

import java.util.List;

import com.baizhi.xzy.entity.Item;

public interface ItemDao {
	//��ӹ�����
	void insertI(Item item);
	
	//��̨�����ݶ���id��ѯÿһ��������||order_id
	List<Item> selectAllI(String oid);
	
}
