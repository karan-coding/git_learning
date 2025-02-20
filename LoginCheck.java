package com.validation;

public class LoginCheck {
	private String result;
	public String loginValidation(String username , String password)
	{
		if (username.length()<4 || username.length()>16) {
			result="Invalid Username";
			
		}
		else if (password.length()<4 || password.length()>16) {
			result="Invalid password";
		}
		else {
			result="VALID";
		}
		
		return result;
		
	}

}
