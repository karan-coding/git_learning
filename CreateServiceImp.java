package com.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.http.Part;

import com.DAO.CURDImp;
import com.dto.ContactDto;
import com.dto.EducationDto;
import com.factory.ConnectionFactory;
import com.fileIO.UploadProjectIO;
import com.fileIO.UploadResumeIO;
import com.mysql.cj.x.protobuf.MysqlxResultset.ContentType_BYTES;
import com.validation.ContactValidation;
import com.validation.EducationValidation;

public class CreateServiceImp implements CreateService {
	 private  String result;
	private CURDImp curdimp;

	public CreateServiceImp() {
		curdimp = new CURDImp();
	}
	@Override
	public String insertContact(ContactDto contactDto) {
		// validation
		ContactValidation contactValidation = new ContactValidation();
		result = contactValidation.validateContact(contactDto);

		if (result.equalsIgnoreCase("valid")) {
			// ok-> DAO

			return curdimp.insertContact(contactDto);
		} else {
			return result;

		}

	}
	@Override
	public String validateProjectFile( String fileName,String contantType, long size) {
		if (!contantType.startsWith("image")) {
			result="Invalide file Type(Image)";
		}
		else if (size>1048576) {
			result="Invalid Image Size";
		}
		else if (fileName.length()<5 || fileName.length()>100) {
			result="Invalid file name";
		}
		else {
			result="VALID";
		}
		return result;
	}
	@Override
	public String insertProjectFile(Part part,String realPath )  {
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			String datetime = LocalDateTime.now().toString();
			String[] split = datetime.split(":");
			String originalFileName = part.getSubmittedFileName();   //project.png
			String formateFileName;
			formateFileName=split[0]+split[1]+split[2]+originalFileName;
			
			//Insert image data inside DB
			//DAO : insert  Success
			    CURDImp curdImp2 = new CURDImp();
			     result = curdImp2.insertProjectFile(formateFileName, connection);
			     if (result.equalsIgnoreCase("Success")) {
			    	 //Insert Actual File in a Folder
			    	 //fail
			    	 //con.rollback()
				UploadProjectIO uploadProjectIO = new UploadProjectIO();	
				result = uploadProjectIO.write(part,formateFileName , realPath  );
				if (result.equalsIgnoreCase("UPLOADED")) {
					connection.commit();
					result= "File Uploaded success";
				}
				else {
					connection.rollback();
					result= "Something Went Worng: FileIO ";
				}
				}
			     else {
			    	 result= "Something Went Worng: DB ";
				}
			
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result= "Something Went Worng: DB ";
		}
		return result;
		
	}
	
	@Override
	public String insertResume(Part part, String realPath) {
		// TODO Auto-generated method stub
		String contentType = part.getContentType();
		String fileName = part.getSubmittedFileName();
		long fileSize = part.getSize();
		 result = validateResume(contentType, fileName, fileSize);
		 if (result.equalsIgnoreCase("Valid")) {
			// FileIO
			 UploadResumeIO uploadResumeIO = new UploadResumeIO();
			  result = uploadResumeIO.write(part, realPath);
			 return result;
		 }
		 else {
			
			 return result;
		} 
		
	}
	public  String validateResume(String contentType,String fileName, long fileSize) {
		if (!contentType.endsWith("pdf")) {
			result="Invalid Resume Type(Only pdf allowed";
		}
		else if (fileName.length()<2 || fileName.length()>100) {
			result="Invalid Resume Name(2 to 100 Character)";
		}
		else if (fileSize>1048576) {
			result="Invalid Pdf Size(Less than 2 MB)";
		}
		else {
			result="VALID";
		}
		
		return result;
		
	}
	@Override
	public String insertEducationService(EducationDto educationdto) {
		  EducationValidation educationValidation = new EducationValidation();
		   result = educationValidation.eduValidation(educationdto);
		   
		   if(result.equalsIgnoreCase("Valid")) {
			
			   
			   CURDImp curdImp2 = new CURDImp();
			   
			   //DAO
			   
			   return curdImp2.insertEducationDao(educationdto);
		   }
		   else {
			   return result;
		   }
		   	   
	}
	
}
