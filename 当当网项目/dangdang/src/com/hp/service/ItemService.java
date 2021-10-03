package com.hp.service;

import java.util.List;

import com.hp.entity.Item;



public interface ItemService {
	//添加购物项
	void addI(Item item);

	//后台：根据订单id查询每一个购物项||order_id
	List<Item> queryAllI(String oid);
}
