package com.hp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.Admin;
import com.hp.service.AdminService;
import com.hp.serviceImpl.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;


public class AdminAction extends ActionSupport{
	//封装属性
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	private String username; //用户名
	private String password; //密码
	private String code; //验证码
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String LoginAction(){
		// 获取session中的验证码随机数
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String serverCode = (String) session.getAttribute("serverCode");
		if(serverCode.equalsIgnoreCase(code)){
			//先比对验证码是否一致
			System.out.println("验证通过");
			//验证通过后调用service方法
			AdminService us = new AdminServiceImpl();
			Admin admin = us.getlogin(username, password);
			if(admin!=null){
				//登陆成功跳转到查询所有页面，成功登陆后存入一个标记
				System.out.println("登录成功");
				session.setAttribute("flag", admin);
//				System.out.println("跳转jsp");
				return "main";
			}else{
				//登陆失败，返回登陆页面
				System.out.println("登陆失败");
				return "login";
			}
		}
		//验证码不通过还在登陆页面
		System.out.println("验证码错误");
		return "login";
	}
}
