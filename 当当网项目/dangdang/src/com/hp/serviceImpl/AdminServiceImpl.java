package com.hp.serviceImpl;

import com.hp.dao.AdminDao;
import com.hp.entity.Admin;
import com.hp.service.AdminService;
import com.hp.util.MybatisUtil;




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
