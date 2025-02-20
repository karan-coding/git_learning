package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.factory.ConnectionFactory;

public class DeleteContactImpDAO implements DeleteData {
       private String result;
	@Override
	public String deleteDAO(int id) {
		try {
			String sql="delete from contact where id=?";
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if (row==1) {
				result="Deleted Successfully";
			}
			else {
				result="Something Went wrong";
			}
		} catch (SQLException e) {
			result="Something Went wrong";
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String deleteProjetFileDao(String filename,Connection connection) {
            		
		 
		try {
			
			String sql="delete from uploadImage where filename=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, filename);
			int row = ps.executeUpdate();
			if (row==1) {
				result="SUCCESS";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Something Went worng";
		}
		
		
		
		
		return result;
	}

}
