package com.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.factory.ConnectionFactory;

public class TableCreation {

	public static void adminTable() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql="create table adminlogin(id int primary key auto_increment,"
				+ " username varchar(16),"
				+ " password varchar(16) )";
		try {
			Statement statement = connection.createStatement();
			boolean execute = statement.execute(sql);
			statement.close();
			
			 sql="insert into adminlogin (username,password) "
			 		+ "values('karan121', 'Karan@123')";
			statement=connection.createStatement();
			statement.execute(sql);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public static void educationTable() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql="create table education (sn int primary key auto_increment,"
				+ "year varchar(10),"
				+ "title varchar(40),"
				+ "subtitle varchar(50),"
				+ " description varchar(100))";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public static void contactTable() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql="create table contact (id int primary key auto_increment,"
				+ "name varchar(10),"
				+ "email varchar(40),"
				+ "message varchar(200),"
				+ " datetime varchar(100))";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public static void projectTable() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		String sql="create table  uploadImage (id int primary key auto_increment,"
				+ "filename varchar(50),"
				+ "datetime varchar(40) )";
				
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
