package com.baizhi.xzy.interceptor;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

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
