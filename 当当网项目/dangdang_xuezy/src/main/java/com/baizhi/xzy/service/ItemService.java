package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.Item;

public interface ItemService {
	//��ӹ�����
	void addI(Item item);

	//��̨�����ݶ���id��ѯÿһ��������||order_id
	List<Item> queryAllI(String oid);
}
