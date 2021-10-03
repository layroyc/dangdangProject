package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.Address;

public interface AddressService {
	//�����û�id��ѯ��ַ
	List<Address> queryByUId(String uid);
	//���ݵ�ַid��ѯ��ϸ��ַ
	Address queryById(String id);
	//��ӵ�ַ
	void addA(Address address);
	//�޸ĵ�ַ
	void changeA(Address address);
}
