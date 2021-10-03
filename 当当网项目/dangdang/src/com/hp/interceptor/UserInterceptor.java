package com.hp.interceptor;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

	//声明一个拦截器，强制登陆

	public class UserInterceptor extends AbstractInterceptor{
		@Override
		public String intercept(ActionInvocation invocation) throws Exception {
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			if(user==null){		
				return "userLogin";
			}else{
				invocation.invoke();//放行
			}
			return null;
		}
	}
