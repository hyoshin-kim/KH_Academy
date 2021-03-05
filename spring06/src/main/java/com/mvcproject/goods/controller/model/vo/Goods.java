package com.mvcproject.goods.controller.model.vo;

import java.util.Date;

public class Goods {
	
	private static final long serialVersionUID = 1111L;
	
	private String code;
	private String name;
	private int price;
	private String color;
	private Date date;
	
	public Goods() {
		
	}
	
	public Goods(String code, String name, int price, String color, Date date) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.color = color;
		this.date = date;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Goods [code=" + code + ", name=" + name + ", price=" + price + ", color=" + color + ", date=" + date
				+ "]";
	}
}
