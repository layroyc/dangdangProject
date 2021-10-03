package com.baizhi.xzy.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.dao.BookDao;
import com.baizhi.xzy.dao.UserDao;
import com.baizhi.xzy.entity.Book;
import com.baizhi.xzy.entity.User;
import com.baizhi.xzy.service.UserService;
import com.baizhi.xzy.util.Md5Utils;
import com.baizhi.xzy.util.MybatisUtil;

public class UserServiceImpl implements UserService{
	//登陆
	public String login(String email,String password) {
		try {
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			User user = dao.findByE(email);
			String message;
			
			//判断用户是否存在
			if(user==null){
				message="用户不存在";
			}else{
				//判断状态
				if(user.getStatus().equals("正常")){
					//判断激活码
					String code = user.getCDK();
					if(code==null){
						message="200";//用户未验证邮箱
					}else{
						String salt = user.getSalt(); //数据库取出盐
						String md5Code = Md5Utils.getMd5Code(password+salt); //与输入密码再次加盐加密
						String psd = user.getPassword();//取出数据库密码
						//判断密码
						if(md5Code.equals(psd)){
							message="100";//登陆成功
							ServletActionContext.getRequest().getSession().setAttribute("user", user);
						}else{
							message="密码错误";
						}
					}
				}else{
					message="用户已冻结";
				}
			}
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("登录失败");
		}finally{
			MybatisUtil.close();
		}
	}

	//注册
	public void regist(User user) {
		try {
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			String salt = Md5Utils.getSalt(6); //获得盐
			user.setSalt(salt); //生成盐之后存进数据库
			String md5Code = Md5Utils.getMd5Code(user.getPassword()+salt); //对用户注册输入的密码加密
			user.setPassword(md5Code); //把加密后的密码存回去代替原来的密码
			String uuid =  UUID.randomUUID().toString();
			user.setId(uuid);
			user.setStatus("正常");
			user.setRegdate(new Date());
			System.out.println(user.getPassword());
			dao.regist(user);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("注册失败");
		} finally {
			MybatisUtil.close();
		}

	}

	//后台：查询所有用户
	public List<User> queryAllU() {
		try {
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			List<User> users = dao.selectAllU();
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("查询失败~");
		} finally {
			MybatisUtil.close();
		}
	}

	//修改CDK
	public void changeCDK(String code,String id) {
		// TODO Auto-generated method stub
		try{
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			dao.updateCDK(code, id);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("修改失败！~");
		}finally{
			MybatisUtil.close();
		}
	}

	//修改状态
	public void changeS(String status, String id) {
		// TODO Auto-generated method stub
		try{
			UserDao dao = (UserDao) MybatisUtil.getMapper(UserDao.class);
			User user = dao.selectById(id);
			
			if(user.getStatus().equals("正常")){
				status="冻结";
			}else{
				status="正常";
			}
			dao.updateS(status, id);
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
