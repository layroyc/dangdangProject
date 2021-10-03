package com.hp.action;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hp.util.SecurityCode;
import com.hp.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;


public class YanZhengMa extends ActionSupport{
	public String execute() throws Exception{
		//1.��ȡ��֤�������
		String securityCode = SecurityCode.getSecurityCode();
		HttpServletRequest request = ServletActionContext.getRequest();//��ȡrequest
		HttpSession session = request.getSession();//��ȡsession
		session.setAttribute("serverCode", securityCode);//����֤�����session������
		//2.��ȡ��֤��ͼƬ
		BufferedImage image = SecurityImage.createImage(securityCode); 

		//3.����֤��ͼƬ��Ӧ���ͻ���
		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream out = response.getOutputStream();

		ImageIO.write(image, "png", out);

		// ����null�����κε���ת
		return null;
	}
}

