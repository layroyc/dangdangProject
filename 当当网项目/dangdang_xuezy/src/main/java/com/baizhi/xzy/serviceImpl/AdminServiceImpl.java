package com.baizhi.xzy.serviceImpl;

import com.baizhi.xzy.dao.AdminDao;
import com.baizhi.xzy.entity.Admin;
import com.baizhi.xzy.service.AdminService;
import com.baizhi.xzy.util.MybatisUtil;


public class AdminServiceImpl implements AdminService{
	//µÇÂ½
	public Admin getlogin(String username, String password) {
		try {
			AdminDao dao = (AdminDao) MybatisUtil.getMapper(AdminDao.class);
			Admin admin = dao.login(username, password);
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("µÇÂ½Ê§°Ü");
		} finally {
			MybatisUtil.close();
		}
	}
}
