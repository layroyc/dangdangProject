package com.hp.dao;

import java.util.List;

import com.hp.entity.Address;



public interface AddressDao {
	//根据用户id查询地址||u_id
	List<Address> selectAllA(String uid); 
	//根据地址id查询地址详情
	Address selectById(String id);
	//添加地址
	void insertA(Address address);
	//修改地址
	void updateA(Address address);
}
