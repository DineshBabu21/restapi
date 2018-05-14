package com.dinesh.shopping.commonservice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dinesh.shopping.commonservice.database.UserData;
import com.dinesh.shopping.commonservice.resources.UserInfo;

@Path("/User")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class User {

	@Path("/AddUser")
	@POST
    public Response AddUser(UserInfo User) {
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		System.out.println("Inside AddUser");
		UserData us = new UserData();
		int result=us.SaveData(User);
		if(result==1)
		{
			rBuilder=Response.ok(200).type(MediaType.APPLICATION_XML);
			response = rBuilder.build();
			return response;
		}
		else
		{
			rBuilder=Response.ok(400).type(MediaType.APPLICATION_XML);
			response = rBuilder.build();
			return response;
		}
		
    }
	
}
