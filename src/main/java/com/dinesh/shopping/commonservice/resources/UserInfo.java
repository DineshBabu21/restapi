package com.dinesh.shopping.commonservice.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class UserInfo {

	private String name;
	private String address;
	private String password;
	private String mNumber;
	private String email;
	
	public UserInfo(){
		
	}
	public UserInfo(String name, String address, String password, String mNumber, String email) {
		this.name = name;
		this.address = address;
		this.password = password;
		this.mNumber = mNumber;
		this.email = email;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlElement
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}
	
}
