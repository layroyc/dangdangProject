package com.baizhi.xzy.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.xzy.entity.Admin;

public interface AdminDao {
	//ʵ�ֺ�̨����Ա��½
	public Admin login(
			@Param(value="username")String username,
			@Param(value="password")String password);
}
