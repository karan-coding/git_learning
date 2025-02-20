package com.start;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.DAO.TableCreation;
import com.DAO.TableDelitation;


public class StartEnd implements ServletContextListener {

   
   
    public void contextDestroyed(ServletContextEvent sce)  { 
       try {
		TableDelitation.adminLoginTableDroped();
		TableDelitation.contactTableDroped();
		TableDelitation.educationTableDroped();
		TableDelitation.projectTableDroped();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         try {
			TableCreation.adminTable();
			TableCreation.contactTable();
			TableCreation.educationTable();
			TableCreation.projectTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
