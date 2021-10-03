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

	//����uid��ѯ
	public String queryAll(){
		//���ø����û���ѯ��ַ�ķ���
		System.out.println("=============");
		AddressService as = new AddressServiceImpl();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		String uid = user.getId();
		System.out.println("==action===id:"+uid);
		addresss = as.queryByUId(uid);
		return "queryAll";
	}
	
	//���ݵ�ַid��ѯ
	public String queryById(){
//		System.out.println("id"+id);
		AddressServiceImpl as = new AddressServiceImpl();
		//��ѯ��ַ��ϸ��Ϣ
		address = as.queryById(id);
		//��ѯ���е�ַ
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		String uid = user.getId();
		addresss = as.queryByUId(uid);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("address", address);
		return "queryById";
	}
	

	//����޸ĵ�ַ
	public String addAndUpdateA(){
		System.out.println(address);
		System.out.println("-------"+address.getId());
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(!("".equals(address.getId()))){
			System.out.println("�޸ĵ�ַ");
			AddressService as = new AddressServiceImpl();
			as.changeA(address);
			session.setAttribute("addressss", address);
		}else{
			System.out.println("������ַ");
			AddressService as = new AddressServiceImpl();
			System.out.println("action:"+address);
			as.addA(address);
			session.setAttribute("addressss", address);
		}
		return "addAndUpdateA";
	}
}
