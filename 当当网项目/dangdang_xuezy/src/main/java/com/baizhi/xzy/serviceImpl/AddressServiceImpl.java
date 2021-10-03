package com.baizhi.xzy.serviceImpl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.dao.AddressDao;
import com.baizhi.xzy.dao.BookDao;
import com.baizhi.xzy.entity.Address;
import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.User;
import com.baizhi.xzy.service.AddressService;
import com.baizhi.xzy.util.MybatisUtil;

public class AddressServiceImpl implements AddressService{

	//根据用户id查询地址
	public List<Address> queryByUId(String uid) {
		try {
			AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
			List<Address> address = dao.selectAllA(uid);
			return address;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//根据地址id查询详细地址
	public Address queryById(String id) {
		try {
			AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
			Address address = dao.selectById(id);
			return address;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
		}finally{
			MybatisUtil.close();
		}
	}

	//添加地址
	public void addA(Address address) {
		// TODO Auto-generated method stub
		try {
			AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
			String uuid =  UUID.randomUUID().toString();
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User) session.getAttribute("user");
//			System.out.println("uuid"+uuid);
//			System.out.println("user_id"+user.getId());
			address.setId(uuid);
			address.setU_id(user.getId());
			System.out.println("service:==="+address);
			dao.insertA(address);
			MybatisUtil.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("添加失败~");
		} finally {
			MybatisUtil.close();
		}

	}

	//修改地址
	public void changeA(Address address) {
		// TODO Auto-generated method stub
		try{
			AddressDao dao = (AddressDao) MybatisUtil.getMapper(AddressDao.class);
			dao.updateA(address);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("修改失败！~");
		}finally{
			MybatisUtil.close();
		}
	}

	
}
