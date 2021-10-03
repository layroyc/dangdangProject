package com.hp.dao;

import java.util.List;

import com.hp.entity.Item;


public interface ItemDao {
	//添加购物项
	void insertI(Item item);
	
	//后台：根据订单id查询每一个购物项||order_id
	List<Item> selectAllI(String oid);
	
}
