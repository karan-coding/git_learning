package com.service;

import javax.servlet.http.Part;

import com.dto.ContactDto;
import com.dto.EducationDto;

public interface CreateService {
      public String insertContact(ContactDto contactDto);
      public String validateProjectFile(String fileName,String contantType, long size);
      public String insertProjectFile(Part part , String realPath);
      public String insertResume(Part part, String realPath);
      public String insertEducationService(EducationDto educationdto);
}
