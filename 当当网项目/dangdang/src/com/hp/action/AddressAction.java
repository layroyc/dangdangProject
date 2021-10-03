package com.hp.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.Address;
import com.hp.entity.User;
import com.hp.service.AddressService;
import com.hp.serviceImpl.AddressServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport{
	private List<Address> addresss;
	private String id;
	private Address address;
	public List<Address> getAddresss() {
		return addresss;
	}

	public void setAddresss(List<Address> addresss) {
		this.addresss = addresss;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//根据uid查询
	public String queryAll(){
		//调用根据用户查询地址的方法
		System.out.println("=============");
		AddressService as = new AddressServiceImpl();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		String uid = user.getId();
		System.out.println("==action===id:"+uid);
		addresss = as.queryByUId(uid);
		return "queryAll";
	}
	
	//根据地址id查询
	public String queryById(){
//		System.out.println("id"+id);
		AddressServiceImpl as = new AddressServiceImpl();
		//查询地址详细信息
		address = as.queryById(id);
		//查询所有地址
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		String uid = user.getId();
		addresss = as.queryByUId(uid);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("address", address);
		return "queryById";
	}
	

	//添加修改地址
	public String addAndUpdateA(){
		System.out.println(address);
		System.out.println("-------"+address.getId());
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(!("".equals(address.getId()))){
			System.out.println("修改地址");
			AddressService as = new AddressServiceImpl();
			as.changeA(address);
			session.setAttribute("addressss", address);
		}else{
			System.out.println("新增地址");
			AddressService as = new AddressServiceImpl();
			System.out.println("action:"+address);
			as.addA(address);
			session.setAttribute("addressss", address);
		}
		return "addAndUpdateA";
	}
}
