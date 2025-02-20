package com.service;

import java.sql.Connection;

import com.DAO.DeleteContactImpDAO;
import com.factory.ConnectionFactory;
import com.fileIO.DelleteProjectIO;

public class DeleteContactImp implements DeleteData {
      private String result;
	@Override
	public String deleteContact(int id) {
		DeleteContactImpDAO deleteContact=new DeleteContactImpDAO();
		 result = deleteContact.deleteDAO(id);
		
		return result;
	}
	@Override
	public String projectFileDeleteService(String filename) {
		  //DAO-> delete->Success
		  //success-> delete from folder
		                         //exp-> rollback
		                         //del-> commit
		try {
			   Connection connection = ConnectionFactory.getConnection();
			   connection.setAutoCommit(false);
			      DeleteContactImpDAO deleteContactImpDAO = new DeleteContactImpDAO();
			      result = deleteContactImpDAO.deleteProjetFileDao(filename,connection);
			      if (result.equalsIgnoreCase("Success")) {
					//delete from folder
			    	  DelleteProjectIO delleteProjectIO = new DelleteProjectIO();
			    	  result= delleteProjectIO.deleteProjectFile(filename);
			    	  if (result.equalsIgnoreCase("Deleted")) {
						connection.commit();
						result="Project deleted success";
					}
			    	  else {
						connection.rollback();
						result="Somethin went worng";
					}
			    	  
				}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Somethin went worng : service";
		}
		    	     
		return result;
	}

}
