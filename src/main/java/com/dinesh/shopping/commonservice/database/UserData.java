package com.dinesh.shopping.commonservice.database;

import com.dinesh.shopping.commonservice.resources.UserInfo;
import java.sql.*;
public class UserData {

	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static String DB_URL = "jdbc:mysql://localhost:3306/customer";
	static final String USER = "root";
	static final String PASS = "redhat";
	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs =null;
	
	public int SaveData(UserInfo User){
		try{
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String UserCheck = "Select * from user where email=?";
		      stmt = conn.prepareStatement(UserCheck);
		      stmt.setString(1, User.getEmail());
		      rs= stmt.executeQuery();
		      if(rs.next())
		      {
		    	  conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return 0;
		      }
		      else
		      {
		      System.out.println("Connected database successfully...");
		      System.out.println("Inserting records into the table...");
		      String sql = "insert into user values(?,?,?,?,?)";
		      //String logintable = "insert into login values(?,?)";
		      stmt = conn.prepareStatement(sql);
		      stmt.setString(1, User.getName());
		      stmt.setString(2,User.getAddress());
		      stmt.setString(3, User.getPassword());
		      stmt.setString(4, User.getmNumber());
		      stmt.setString(5, User.getEmail());
		      stmt.execute();
		      conn.close();
	    	  stmt.close();
	    	  rs.close();
		      return 1;
		      }
		 
		}catch (Exception e)
		{
			 System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		      return 0;
		}
		
	}
	
	public int UpdateData(UserInfo User){
	
		try{
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String UserCheck = "Select * from user where email=?";
		      stmt = conn.prepareStatement(UserCheck);
		      stmt.setString(1, User.getEmail());
		      rs= stmt.executeQuery();
		      System.out.println("result set "+rs);
		      if(!rs.next())
		      {
		    	  conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return 0;
		      }
		      else
		      {
		      System.out.println("Connected database successfully...");
		      System.out.println("Updating records in the table...");
		      String sql = "UPDATE user SET name=?, address=?, mnumber=? WHERE email=?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setString(1, User.getName());
		      stmt.setString(2,User.getAddress());
		      stmt.setString(3, User.getmNumber());
		      stmt.setString(4, User.getEmail());
		      stmt.executeUpdate();
		      conn.close();
	    	  stmt.close();
	    	  rs.close();
		      return 1;
		      }
	}catch (Exception e)
		{
		 System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return 0;
	}	
	}
	
	public int UpdatePassword(UserInfo User){
		
		try{
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String UserCheck = "Select * from user where email=?";
		      stmt = conn.prepareStatement(UserCheck);
		      stmt.setString(1, User.getEmail());
		      rs= stmt.executeQuery();
		      if(!rs.next())
		      {
		    	  conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return 0;
		      }
		      else
		      {
		      System.out.println("Connected database successfully...");
		      System.out.println("Updating password records in the table...");
		      String sql = "UPDATE user SET password=? WHERE email=?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setString(1, User.getPassword());
		      stmt.setString(2, User.getEmail());
		      stmt.executeUpdate();
		      conn.close();
	    	  stmt.close();
	    	  rs.close();
		      return 1;
		      }
	}catch (Exception e)
		{
		 System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return 0;
	}	
	}
	
	
	public UserInfo ListUserInfo(String email){
		try{
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String UserCheck = "Select * from user where email=?";
		      System.out.println("email id to fetched--->"+email);
		      stmt = conn.prepareStatement(UserCheck);
		      stmt.setString(1, email);
		      System.out.println("Query to be Executed"+stmt.toString());
		      rs= stmt.executeQuery();
		      UserInfo userInfo = null;
		      if (rs.next()){
		      //System.out.println("Result Set String -----------"+rs.getString("name")+rs.getString("address")+rs.getString("password")+rs.getString("mnumber")+rs.getString("email"));
		      userInfo = new UserInfo(rs.getString("name"),rs.getString("address"),rs.getString("password"),rs.getString("mnumber"),rs.getString("email"));
		      conn.close();
	    	  stmt.close();
	    	  rs.close();
		      return userInfo;
		      }
		      else
		      {
		    	  conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return userInfo;
		      }
		      
		      
		}
		catch (Exception e)
		{
		 System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return null;
	}
	}
	
	
	public int DeleteUser(String email){
		try{
			Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String UserCheck = "Select * from user where email=?";
		      stmt = conn.prepareStatement(UserCheck);
		      stmt.setString(1, email);
		      rs= stmt.executeQuery();
		      System.out.println("result set "+rs);
		      if(!rs.next())
		      {
		    	  conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return 0;
		      }
		      else
		      {
		    	  System.out.println("Connected database successfully...");
			      System.out.println("Updating records in the table...");
			      String sql = "delete from user WHERE email=?";
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1, email);
			      stmt.executeUpdate();
			      conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return 1;  
		      }      
		}
		catch (Exception e)
		{
		 System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return 0;
	}
	}
	
	
	public UserInfo LoginUser(UserInfo User){
		UserInfo us = null;
		try{
			  Class.forName(JDBC_DRIVER);
			  System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      String UserCheck = "select * from user where email=? and password=?";
		      stmt = conn.prepareStatement(UserCheck);
		      stmt.setString(1, User.getEmail());
		      stmt.setString(2, User.getPassword() );
		      System.out.println("Query to be executed "+stmt.toString());
		      rs= stmt.executeQuery();
		      if(rs.next())
		      {
		    	  us= new UserInfo(rs.getString("name"),rs.getString("address"),rs.getString("password"),rs.getString("mnumber"),rs.getString("email"));
		    	  conn.close();
		    	  stmt.close();
		    	  rs.close();
		    	  return us;
		      }
		      else
		      {
		      conn.close();
	    	  stmt.close();
	    	  rs.close();
		      return us;
		      }
		 
		}catch (Exception e)
		{
			 System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		      return us;
		}
		
	}
}
