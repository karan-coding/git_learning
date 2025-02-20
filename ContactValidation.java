package com.validation;

import com.dto.ContactDto;

public class ContactValidation {
	
	 private String  result;
 public String validateContact(ContactDto contactDto) {
	 if (contactDto.getName().length()<2||contactDto.getName().length()>30) {
		result="Invalid Name";
	} 
	 else if (contactDto.getEmail().length()<5||contactDto.getEmail().length()>50) {
		result="Invalid Email";
	}
	 else if (contactDto.getMessage().length()<2||contactDto.getMessage().length()>100) {
		result="Invalid message";
	}
	 else {
		 result="VALID";
	 } 
	return result;
	 
 }
}
