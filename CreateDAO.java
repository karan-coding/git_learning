package com.DAO;



import java.sql.Connection;

import com.dto.ContactDto;
import com.dto.EducationDto;

public interface CreateDAO {
	public String insertContact(ContactDto contactDto);
	public String insertProjectFile(String formateFileName, Connection con );
	public String insertEducationDao(EducationDto educationDto);

}
