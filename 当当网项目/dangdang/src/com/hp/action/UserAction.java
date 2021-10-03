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
	//ǰ̨����¼
		public String loginAction(){
			System.out.println("=action==email: "+email); 
			System.out.println("=action==password: "+password); 
			
			UserServiceImpl usi = new UserServiceImpl();
			message = usi.login(email, password);
			
			if(message.equals("200")){
				//��ת�����伤��ҳ��
				return "Email";
			}else if(message.equals("100")){
				//��ת����ҳ
				return "loginOK";
			}else{
				//��ת����¼ҳ��
				return "loginError";
			}
		}
		
	//ע��
	public String regist(){
		UserService us = new UserServiceImpl();
		us.regist(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		return "regist";
	}

	//��ȡ��������ַ�
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
	//ǰ̨����֤����
	public String check(){
		System.out.println("11111");
		String random = (String) ServletActionContext.getRequest().getSession().getAttribute("random");
		if(random.equals(code)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User) session.getAttribute("user");
			System.out.println("code========"+code);
			System.out.println("user====="+user);
			//�����û��޸ķ���
			//������������û�
			UserService us = new UserServiceImpl();
			us.changeCDK(code, user.getId());
			return "checkOk";
		}else{
			return "checkError";
		}
	}
	
	//��̨����װ��ѯ�����û�����
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	//��̨����ѯ�����û�
	public String findAllU(){
		UserService us = new UserServiceImpl();
		users = us.queryAllU();
		for(User u:users){
			System.out.println("��ѯ�����û���"+u);
		}
		return "findAllU";
	}
	
	//ǰ̨�˳�
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
	//��̨���޸�״̬
	public String updateS(){
		UserService us = new UserServiceImpl();
		System.out.println("=====״̬�� "+status);
		System.out.println("=====id�� "+id);
		
		us.changeS(status, id);
		return "updateS";
	}
}
