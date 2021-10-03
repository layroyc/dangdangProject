package com.hp.dao;

import java.util.List;

import com.hp.entity.Address;



public interface AddressDao {
	//�����û�id��ѯ��ַ||u_id
	List<Address> selectAllA(String uid); 
	//���ݵ�ַid��ѯ��ַ����
	Address selectById(String id);
	//��ӵ�ַ
	void insertA(Address address);
	//�޸ĵ�ַ
	void updateA(Address address);
}
