package com.baizhi.xzy.entity;

import java.io.Serializable;

public class Item implements Serializable{
	private String  id;
	private String  book_name; //书名||商品名
	private Double  discount_price;//商品单价||当当价
	private Integer  count;//商品数量
	private Double  priceTotal; //小计
	private String  book_id;//图书id
	private String  order_id;//订单id
	private String cover;
	private String status;
	private Double original_price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(Double discount_price) {
		this.discount_price = discount_price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(Double original_price) {
		this.original_price = original_price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", book_name=" + book_name
				+ ", discount_price=" + discount_price + ", count=" + count
				+ ", priceTotal=" + priceTotal + ", book_id=" + book_id
				+ ", order_id=" + order_id + ", cover=" + cover + ", status="
				+ status + ", original_price=" + original_price + "]";
	}
	public Item(String id, String book_name, Double discount_price,
			Integer count, Double priceTotal, String book_id, String order_id,
			String cover, String status, Double original_price) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.discount_price = discount_price;
		this.count = count;
		this.priceTotal = priceTotal;
		this.book_id = book_id;
		this.order_id = order_id;
		this.cover = cover;
		this.status = status;
		this.original_price = original_price;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
