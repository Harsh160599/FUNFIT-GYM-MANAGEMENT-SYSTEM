package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
	public static Connection getConnection() throws Exception {
		Connection conObj = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	      conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","Raj@12345");
	      if(conObj!=null)
			{
				System.out.println("DataBase");
			}
		} catch (Exception e) {
			// TODO: handle exception
			conObj=null;
			System.out.println(e);
		}
		return conObj;
	}
}
