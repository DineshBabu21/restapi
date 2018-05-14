package com.dinesh.shopping.commonservice.database;

import com.dinesh.shopping.commonservice.resources.UserInfo;
import java.sql.*;
public class UserData {

	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static String DB_URL = "jdbc:mysql://localhost:3306/restdb";
	static final String USER = "root";
	static final String PASS = "redhat";
	Connection conn = null;
	PreparedStatement stmt=null;
	public int SaveData(UserInfo User){
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		      String sql = "insert into user values(?,?,?,?,?)";
		      stmt = conn.prepareStatement(sql);
		      stmt.setString(1, User.getName());
		      stmt.setString(2,User.getAddress());
		      stmt.setString(3, User.getPassword());
		      stmt.setInt(4, User.getmNumber());
		      stmt.setString(5, User.getEmail());
		      stmt.execute();
		    		  
		      conn.close();
		      return 1;
		}catch (Exception e)
		{
			 System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		      return 0;
		}
		
	}
	
}
