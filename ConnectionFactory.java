package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
       static Connection con=null;	
	public static Connection getConnection() {
		try {
			String url="jdbc:mysql://localhost:3306/project";
			String username="root";
			String password="root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  con ;
		
	}

}
