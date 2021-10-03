package com.baizhi.xzy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.User;

public interface UserDao {
	//ǰ��
	//��½
//	User login(
//			@Param(value="email")String email,
//			@Param(value="password")String password);
	User findByE(String email);
	//ע��
	void regist(User user);
	//�޸�CDK������
	void updateCDK(
			@Param("code")String CDK,
			@Param("id")String id);
	
	//���
	//��ѯ�����û�
	List<User> selectAllU();
	//�޸�״̬
	void updateS(
			@Param("status")String status,
			@Param("id")String id);
	//����id�����û�
	User selectById(String id);
}
