package com.hp.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.Item;
import com.hp.entity.Order;
import com.hp.service.ItemService;
import com.hp.service.OrderService;
import com.hp.serviceImpl.ItemServiceImpl;
import com.hp.serviceImpl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	
	//订单，订单项入库 ||添加订单和订单详细信息
	public String addOI(){
		OrderService os = new OrderServiceImpl();
		os.addO();
		return "addOI";
	}
	
	//封装后台：查询所有订单集合
	private List<Order> orders;
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	//查询所有订单
	public String findAllO(){
		OrderService os = new OrderServiceImpl();
		orders = os.queryAll();
		for(Order o:orders){
			System.out.println("==action:orders:"+o);
		}
		return "findAllO";
	}
	
	private String oid; //订单id
	private List<Item> items; //订单项集合
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	private Double tatolPrice=0.0;
	//根据订单id查询所有购物项
	public String FindAllI(){
		ItemService is = new ItemServiceImpl();
		items = is.queryAllI(oid);
		
		for(Item i:items){
			System.out.println("==action:items:"+i);
			tatolPrice=tatolPrice+i.getPriceTotal();
		}
		ServletActionContext.getRequest().getSession().setAttribute("tatolPrice", tatolPrice);
		return "FindAllI";
	}

	public Double getTatolPrice() {
		return tatolPrice;
	}

	public void setTatolPrice(Double tatolPrice) {
		this.tatolPrice = tatolPrice;
	}
	
}
