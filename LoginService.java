package com.service;

import com.DAO.LoginDAOimp;
import com.validation.LoginCheck;

public class LoginService  implements adminLogin{
private String result;
	

	@Override
	public String LoginService(String username, String password) {
		LoginCheck loginCheck = new LoginCheck();
		result = loginCheck.loginValidation(username, password);
		if(result.equalsIgnoreCase("VALID")) {
			//DAO
			LoginDAOimp loginDAOimp = new LoginDAOimp();
			 result = loginDAOimp.loginDAO(username, password);
		}
		else {
			return result;
			
		}
		return result;
	}

}
