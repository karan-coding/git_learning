package com.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.factory.ConnectionFactory;

public class TableDelitation {
	public static void adminLoginTableDroped() throws SQLException {
	   Connection con = ConnectionFactory.getConnection();	
	   try {
		String sql="drop table adminlogin";
		Statement statement = con.createStatement();
		statement.execute(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   finally {
		con.close();
	}
	}
public static void educationTableDroped() throws SQLException {
	Connection con = ConnectionFactory.getConnection();	
	   try {
		String sql="drop table education";
		Statement statement = con.createStatement();
		statement.execute(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   finally {
		con.close();
	}
	}
public static void contactTableDroped() throws SQLException {
	Connection con = ConnectionFactory.getConnection();	
	   try {
		String sql="drop table contact";
		Statement statement = con.createStatement();
		statement.execute(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   finally {
		con.close();
	}
}
public static void projectTableDroped() throws SQLException {
	Connection con = ConnectionFactory.getConnection();	
	   try {
		String sql="drop table uploadImage";
		Statement statement = con.createStatement();
		statement.execute(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   finally {
		con.close();
	}
}

}
