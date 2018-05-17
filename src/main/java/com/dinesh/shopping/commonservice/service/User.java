package com.dinesh.shopping.commonservice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dinesh.shopping.commonservice.database.UserData;
import com.dinesh.shopping.commonservice.resources.UserInfo;
import com.dinesh.shopping.commonservice.resources.UserResponse;

@Path("/User")

public class User {

	@POST
	@Path("/AddUser")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response AddUser(UserInfo User) {
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		//System.out.println("--------Number---------"+User.getmNumber());
		System.out.println("Inside AddUser");
		UserData us = new UserData();
		
		int result=us.SaveData(User);
		UserResponse UR = new UserResponse(User,result);
		if(result==1)
		{
			return Response.ok(UR).build(); 
		}
		else
		{
			return Response.ok(UR).build(); 
		}
		
    }
	
	@POST
	@Path("/UpdateUser")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response UpdateUser(UserInfo User)
	{
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		System.out.println("Inside UpdateUser");
		UserData us = new UserData();
		int result=us.UpdateData(User);
		UserResponse UR = new UserResponse(User,result);
		if(result==1)
		{
			return Response.ok(UR).build(); 
		}
		else
		{
			return Response.ok(UR).build(); 
		}
	}
	
	@POST
	@Path("/UpdatePassword")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response UpdatePassword(UserInfo User)
	{
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		System.out.println("Inside UpdatePassword");
		UserData us = new UserData();
		int result=us.UpdatePassword(User);
		UserResponse UR = new UserResponse(User,result);
		if(result==1)
		{
			return Response.ok(UR).build(); 
		}
		else
		{
			return Response.ok(UR).build(); 
		}
	}
	
	@GET
	@Path("/Get/{emailid}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response ListUserInfo(@PathParam("emailid") String email)
	{
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		System.out.println("Inside UserInfo");
		UserData us = new UserData();
		UserInfo result=us.ListUserInfo(email);
		
		
		
		if(result!= null){
			UserResponse UR = new UserResponse(result,1);
			return Response.ok(UR).build(); 
		}
		else
		{
			UserResponse UR = new UserResponse(new UserInfo(),0);
			return Response.ok(UR).build(); 
		}
		
	}
	
	@GET
	@Path("/Delete/{emailid}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response Delete(@PathParam("emailid") String email)
	{
		Response.ResponseBuilder rBuilder=null;
		Response response=null;
		System.out.println("Inside UserInfo");
		UserData us = new UserData();
		int result=us.DeleteUser(email);
		
		if(result== 1){
			UserResponse UR = new UserResponse(new UserInfo(),1);
			return Response.ok(UR).build(); 
		}
		else
		{
			UserResponse UR = new UserResponse(new UserInfo(),0);
			return Response.ok(UR).build(); 
		}
		
	}
}
