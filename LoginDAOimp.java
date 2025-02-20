package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.factory.ConnectionFactory;

public class LoginDAOimp implements LoginDAO {
      private String result;
	@Override
	public String loginDAO(String username, String password) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="select * from adminlogin where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean isExist = rs.next();
			if(isExist) {
				result="EXIST";
			}
			else {
				result="NOTEXIST";
			}
		} catch (Exception e) {
			result="Something went worng!";
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

}
