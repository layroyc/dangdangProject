package com.hp.service;

import java.util.List;

import com.hp.entity.Item;



public interface ItemService {
	//��ӹ�����
	void addI(Item item);

	//��̨�����ݶ���id��ѯÿһ��������||order_id
	List<Item> queryAllI(String oid);
}
