package com.dinesh.shopping.commonservice.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class UserResponse {
	
	private String message;
	private String sCode;
	private String name;
	private String address;
	private String mNumber;
	private String email;
	
	public UserResponse(){
		
	}
	
	public UserResponse(UserInfo User,int result){
		if(result==1)
		{
		 message = "Action Success";
		 sCode = "200";
		 this.name = User.getName();
		 this.address= User.getAddress();
		 this.mNumber = User.getmNumber();
		 this.email = User.getEmail();
		}
		if(result == 0)
		{
			message = "Action Failed";
			sCode = "400";
			this.name = User.getName();
			this.address= User.getAddress();
			this.mNumber = User.getmNumber();
			this.email = User.getEmail();
		}
	}
	
	@XmlElement
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@XmlElement
	public String getsCode() {
		return sCode;
	}
	public void setsCode(String sCode) {
		this.sCode = sCode;
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
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
