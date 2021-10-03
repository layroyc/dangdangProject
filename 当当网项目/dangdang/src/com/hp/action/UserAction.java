package com.hp.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.User;
import com.hp.service.UserService;
import com.hp.serviceImpl.UserServiceImpl;
import com.hp.util.Md5Utils;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private String email;
	private String message;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//前台：登录
		public String loginAction(){
			System.out.println("=action==email: "+email); 
			System.out.println("=action==password: "+password); 
			
			UserServiceImpl usi = new UserServiceImpl();
			message = usi.login(email, password);
			
			if(message.equals("200")){
				//跳转到邮箱激活页面
				return "Email";
			}else if(message.equals("100")){
				//跳转到首页
				return "loginOK";
			}else{
				//跳转到登录页面
				return "loginError";
			}
		}
		
	//注册
	public String regist(){
		UserService us = new UserServiceImpl();
		us.regist(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		return "regist";
	}

	//获取邮箱随机字符
	public String random(){
		String random = Md5Utils.getSalt(6);
		ServletActionContext.getRequest().getSession().setAttribute("random", random);			
		return "random";
	}

	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	//前台：验证邮箱
	public String check(){
		System.out.println("11111");
		String random = (String) ServletActionContext.getRequest().getSession().getAttribute("random");
		if(random.equals(code)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User) session.getAttribute("user");
			System.out.println("code========"+code);
			System.out.println("user====="+user);
			//调用用户修改方法
			//将激活码存入用户
			UserService us = new UserServiceImpl();
			us.changeCDK(code, user.getId());
			return "checkOk";
		}else{
			return "checkError";
		}
	}
	
	//后台：封装查询所有用户集合
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	//后台：查询所有用户
	public String findAllU(){
		UserService us = new UserServiceImpl();
		users = us.queryAllU();
		for(User u:users){
			System.out.println("查询所有用户："+u);
		}
		return "findAllU";
	}
	
	//前台退出
	public String exit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "exit";
	}
	
	private String id;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//后台：修改状态
	public String updateS(){
		UserService us = new UserServiceImpl();
		System.out.println("=====状态： "+status);
		System.out.println("=====id： "+id);
		
		us.changeS(status, id);
		return "updateS";
	}
}
