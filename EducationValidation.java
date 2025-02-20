package com.validation;

import com.dto.EducationDto;

public class EducationValidation {
	private String result;
	  public String eduValidation(EducationDto educationdto) {
		  
		  
		  if (educationdto.getYear().length()!=4) {
			result="Invalid Year";
		}
		  else if (educationdto.getTitle().length()<2 || educationdto.getTitle().length()>15) {
			result="Invalid Title";
		}
		  else if (educationdto.getSubtitle().length()<2 || educationdto.getSubtitle().length()>25) {
			result="Invalid SubTitle";
		}
		  else if (educationdto.getDescription().length()<10 || educationdto.getSubtitle().length()>100) {
			result="Ivalid Description";
		}
		  else {
			  result="VALID";
		  }
		  
		  
		  
		  return result;
	  }
	  

}
