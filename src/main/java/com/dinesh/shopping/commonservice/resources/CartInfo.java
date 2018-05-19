package com.dinesh.shopping.commonservice.resources;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cart")
public class CartInfo {
	
	private UserInfo user;
	private ArrayList<Item> products;
	
	public CartInfo() {
	}
	public CartInfo(UserInfo user, ArrayList<Item> products) {
		this.user = user;
		this.products = products;
	}
	
	@XmlElement
	public UserInfo getUser() {
		return user;
	}
	
	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	@XmlElement
	public ArrayList<Item> getProducts() {
		return products;
	}
	
	public void setProducts(ArrayList<Item> products) {
		this.products = products;
	}
	
	
	
	

}
