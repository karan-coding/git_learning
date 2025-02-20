package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.dto.ContactDto;
import com.dto.EducationDto;
import com.factory.ConnectionFactory;

public class CURDImp implements CreateDAO {
    private   String result;
	@Override
	public String insertContact(ContactDto contactDto) {
          try {
			//ConnectionFactory connection=new ConnectionFactory();
			Connection con = ConnectionFactory.getConnection();
			//System.out.println(con);
			String sql="insert into contact (name,email,message,datetime)"
					+ "values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contactDto.getName());
			ps.setString(2, contactDto.getEmail());
			ps.setString(3, contactDto.getMessage());
			ps.setString(4, LocalDateTime.now().toString());
			int row = ps.executeUpdate();
			if (row==1) {
				result="Data Inserted Successfully";
			}
		} catch (Exception e) {
			result="Something went worng";
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String insertProjectFile(String formateFileName, Connection con ) {
		try {
			
			String sql="insert into uploadImage (filename,datetime)"
					+ "values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,formateFileName);
			ps.setString(2, LocalDateTime.now().toString());
			int row = ps.executeUpdate();
			if (row==1) {
				result="SUCCESS";
			}
		} catch (Exception e) {
			result="Fail";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String insertEducationDao(EducationDto educationDto) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = ConnectionFactory.getConnection();
			String sql="insert into education (year,title,subtitle,description) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, educationDto.getYear());
			ps.setString(2, educationDto.getTitle());
			ps.setString(3, educationDto.getSubtitle());
			ps.setString(4, educationDto.getDescription());
			int row = ps.executeUpdate();
			if (row==1) {
				result="Education Inserted Successfully";
			}
			else {
				result="Something went Worng";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Something went Worng";
		}
		return result;
	}
	
	}
	


	
	


