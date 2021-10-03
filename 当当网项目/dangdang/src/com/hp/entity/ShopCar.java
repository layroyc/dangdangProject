package com.hp.entity;

import java.io.Serializable;

public class ShopCar implements Serializable{
	private String book_name;
	private Double original_price; //原价
	private Double discount_price; //当当价
	private Integer count;//购物车 ||数量
	private Integer stutas;//状态
	private Double priceTotal;//小计
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(Double original_price) {
		this.original_price = original_price;
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
	public Integer getStutas() {
		return stutas;
	}
	public void setStutas(Integer stutas) {
		this.stutas = stutas;
	}
	public Double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}
	@Override
	public String toString() {
		return "ShopCar [book_name=" + book_name + ", original_price="
				+ original_price + ", discount_price=" + discount_price
				+ ", count=" + count + ", stutas=" + stutas + ", priceTotal="
				+ priceTotal + "]";
	}
	public ShopCar(String book_name, Double original_price,
			Double discount_price, Integer count, Integer stutas,
			Double priceTotal) {
		super();
		this.book_name = book_name;
		this.original_price = original_price;
		this.discount_price = discount_price;
		this.count = count;
		this.stutas = stutas;
		this.priceTotal = priceTotal;
	}
	public ShopCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
