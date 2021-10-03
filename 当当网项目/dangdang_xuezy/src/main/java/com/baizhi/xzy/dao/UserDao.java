package com.baizhi.xzy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.User;

public interface UserDao {
	//前端
	//登陆
//	User login(
//			@Param(value="email")String email,
//			@Param(value="password")String password);
	User findByE(String email);
	//注册
	void regist(User user);
	//修改CDK激活码
	void updateCDK(
			@Param("code")String CDK,
			@Param("id")String id);
	
	//后端
	//查询所有用户
	List<User> selectAllU();
	//修改状态
	void updateS(
			@Param("status")String status,
			@Param("id")String id);
	//根据id查找用户
	User selectById(String id);
}
