package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.User;

public interface UserService {
	//��½
//	User login(String email,String password);
	String login(String email,String password);
	//ע��
	void regist(User user); 
	//�޸�CDK
	void changeCDK(String code,String id);
	
	//��̨����ѯ�����û�
	List<User> queryAllU();
	//�޸�״̬
	void changeS(String status,String id);
}
