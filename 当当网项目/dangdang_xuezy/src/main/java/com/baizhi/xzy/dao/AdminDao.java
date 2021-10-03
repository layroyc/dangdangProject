package com.baizhi.xzy.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.Admin;

public interface AdminDao {
	//实现后台管理员登陆
	public Admin login(
			@Param(value="username")String username,
			@Param(value="password")String password);
}
