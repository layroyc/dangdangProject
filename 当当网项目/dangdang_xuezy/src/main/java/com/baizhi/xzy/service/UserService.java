package com.baizhi.xzy.service;

import java.util.List;

import com.baizhi.xzy.entity.User;

public interface UserService {
	//登陆
//	User login(String email,String password);
	String login(String email,String password);
	//注册
	void regist(User user); 
	//修改CDK
	void changeCDK(String code,String id);
	
	//后台：查询所有用户
	List<User> queryAllU();
	//修改状态
	void changeS(String status,String id);
}
