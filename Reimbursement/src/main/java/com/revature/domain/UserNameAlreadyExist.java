package com.revature.domain;

import java.sql.SQLException;

public class UserNameAlreadyExist extends Exception{
	
	public void UserNameAlreadyExist() {
		System.out.println("This username already exist.");
		//System.out.println("Please enter a new new username: ");
		
	}

}
