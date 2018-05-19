package com.dinesh.shopping.commonservice.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Item {
	
	private String itemCode;
	private String itemName;
	private int quantity;
	private int price; 
	
	public Item(){
		
	}

	public Item(String itemCode, String itemName, int quantity, int price) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}



	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
