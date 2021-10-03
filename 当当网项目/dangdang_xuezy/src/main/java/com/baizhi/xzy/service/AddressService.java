package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.Address;

public interface AddressService {
	//根据用户id查询地址
	List<Address> queryByUId(String uid);
	//根据地址id查询详细地址
	Address queryById(String id);
	//添加地址
	void addA(Address address);
	//修改地址
	void changeA(Address address);
}
