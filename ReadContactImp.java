package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Modle.BindData;
import com.Modle.EducationModle;
import com.Modle.projectFile;
import com.factory.ConnectionFactory;

public class ReadContactImp implements ReadContact {
      List<BindData> list=new ArrayList<BindData>();
	@Override
	public List<BindData> readeContact() {
		try {
			Connection connection = ConnectionFactory.getConnection(); //connectDatabase
			PreparedStatement ps = connection.prepareStatement("select * from contact");
			ResultSet result = ps.executeQuery();  //Fetch data from database
			while (result.next()) {
//				BindData bindData = new BindData(result.getInt("id"), result.getString("name"), result.getString("email"),
//						result.getString("message"), result.getString("datetime")); 
//				list.add(bindData);
				list.add( new BindData(result.getInt("id"), result.getString("name"), result.getString("email"),
						result.getString("message"), result.getString("datetime"))); //add one by one data into list
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; //return collection of data as list
	}
	@Override
	public List<projectFile> readProjectFileData() {
		// TODO Auto-generated method stub
		 List<projectFile> list=new ArrayList<projectFile>();
		try {
			Connection connection = ConnectionFactory.getConnection(); //connectDatabase
			PreparedStatement ps = connection.prepareStatement("select * from uploadImage");
			ResultSet rs = ps.executeQuery(); 
		while(rs.next()) {
				list.add( new projectFile(rs.getInt("id"), rs.getString("filename"), rs.getString("datetime"))); //add one by one data into list
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<EducationModle> readEducation() {
		
		
		
		 List<EducationModle> list=new ArrayList<EducationModle>();
			
				try {
					Connection connection = ConnectionFactory.getConnection(); //connectDatabase
					PreparedStatement ps = connection.prepareStatement("select * from education");
					ResultSet rs = ps.executeQuery();  //Fetch data from database
					while (rs.next()) {
//						BindData bindData = new BindData(result.getInt("id"), result.getString("name"), result.getString("email"),
//								result.getString("message"), result.getString("datetime")); 
//						list.add(bindData);
						 //add one by one data into list
					     list.add( new EducationModle(rs.getInt("sn"), rs.getString("year"),rs.getString("title"), rs.getString("subtitle"), rs.getString("description")));  
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list; //return collection of data as list
	}

}
