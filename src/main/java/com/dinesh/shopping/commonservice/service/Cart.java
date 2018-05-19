package com.dinesh.shopping.commonservice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dinesh.shopping.commonservice.resources.CartInfo;
import com.dinesh.shopping.commonservice.resources.UserInfo;

public class Cart {

	@POST
	@Path("/AddtoCart")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public CartInfo addItem(CartInfo cart)
	{
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		System.out.println("Inside Additem");
		
	}
}
