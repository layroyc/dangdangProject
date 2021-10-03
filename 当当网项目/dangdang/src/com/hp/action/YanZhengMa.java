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
		//1.获取验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		HttpServletRequest request = ServletActionContext.getRequest();//获取request
		HttpSession session = request.getSession();//获取session
		session.setAttribute("serverCode", securityCode);//将验证码存入session作用域
		//2.获取验证码图片
		BufferedImage image = SecurityImage.createImage(securityCode); 

		//3.将验证码图片响应到客户端
		HttpServletResponse response = ServletActionContext.getResponse();
		OutputStream out = response.getOutputStream();

		ImageIO.write(image, "png", out);

		// 返回null不做任何的跳转
		return null;
	}
}

