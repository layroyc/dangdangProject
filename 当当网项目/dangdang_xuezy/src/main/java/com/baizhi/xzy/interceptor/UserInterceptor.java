package com.baizhi.xzy.interceptor;

import org.apache.struts2.ServletActionContext;

import com.baizhi.xzy.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

	//����һ����������ǿ�Ƶ�½

	public class UserInterceptor extends AbstractInterceptor{
		@Override
		public String intercept(ActionInvocation invocation) throws Exception {
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			if(user==null){		
				return "userLogin";
			}else{
				invocation.invoke();//����
			}
			return null;
		}
	}
