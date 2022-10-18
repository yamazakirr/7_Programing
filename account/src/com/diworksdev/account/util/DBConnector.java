package com.diworksdev.account.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:8889/account";
	private static String user = "root";
	private static String password = "root";

	public Connection getConnection(){
		Connection con = null;


		try{
			Class.forName(driverName);
			System.out.println("getConnection(url,user,password) : "+(Connection)DriverManager.getConnection(url,user,password));

			con = (Connection)DriverManager.getConnection(url,user,password);

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return con;
	}
}
