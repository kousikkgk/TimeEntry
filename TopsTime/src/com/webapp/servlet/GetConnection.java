package com.webapp.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection 
{
	public int getConn(String query) {
		Statement statement=null;
		Connection conn=null;
		ResultSet rs = null;
		int empid = 0;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:3306/tops";
	    final String USER = "root";
	    final String PASS = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error in Driver.....");
			e.printStackTrace();
		}
	
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			System.out.println("Error in Connection.....");
			e.printStackTrace();
		}
	  	
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Error in Statment.....");
			e.printStackTrace();
		}
		try {
			rs=statement.executeQuery(query);
			
		} catch (SQLException e) {
			System.out.println("Error in Query.....");
			e.printStackTrace();
		}
			try {
				while(rs.next()) 
				{
					empid=rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("Error in Result set");
				e.printStackTrace();
			}
			return empid;
		}
	}
