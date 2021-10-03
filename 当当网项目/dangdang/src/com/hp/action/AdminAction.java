package com.hp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.Admin;
import com.hp.service.AdminService;
import com.hp.serviceImpl.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;


public class AdminAction extends ActionSupport{
	//��װ����
	private Admin admin;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	private String username; //�û���
	private String password; //����
	private String code; //��֤��
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
		// ��ȡsession�е���֤�������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String serverCode = (String) session.getAttribute("serverCode");
		if(serverCode.equalsIgnoreCase(code)){
			//�ȱȶ���֤���Ƿ�һ��
			System.out.println("��֤ͨ��");
			//��֤ͨ�������service����
			AdminService us = new AdminServiceImpl();
			Admin admin = us.getlogin(username, password);
			if(admin!=null){
				//��½�ɹ���ת����ѯ����ҳ�棬�ɹ���½�����һ�����
				System.out.println("��¼�ɹ�");
				session.setAttribute("flag", admin);
//				System.out.println("��תjsp");
				return "main";
			}else{
				//��½ʧ�ܣ����ص�½ҳ��
				System.out.println("��½ʧ��");
				return "login";
			}
		}
		//��֤�벻ͨ�����ڵ�½ҳ��
		System.out.println("��֤�����");
		return "login";
	}
}
