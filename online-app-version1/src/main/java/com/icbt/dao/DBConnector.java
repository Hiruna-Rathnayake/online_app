package com.icbt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/dbName";
	private static DBConnector instance;
	private Connection connection;
	
	private DBConnector()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="";
			String username ="";
			String password = "";
			this.connection = DriverManager.getConnection(url, username , password);
		} catch (ClassNotFoundException  | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static DBConnector getInstance()
	{
		if(instance ==null)
		{
			synchronized (DBConnector.class) {
				if(instance == null)
				{
					instance = new DBConnector();
				}
				
			}
		}
		 return instance;
		
	}

}
