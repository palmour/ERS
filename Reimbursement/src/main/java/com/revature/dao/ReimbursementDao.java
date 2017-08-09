package com.revature.dao;

import com.revature.domain.Employee;
import com.revature.domain.UserNameAlreadyExist;

public interface ReimbursementDao {

	public Employee CreateNewEmp(String us, String pw, String fname, 
			String lname, String email);
	public boolean LoginIn(String us, String pw);
	public Employee LoginIn2(String us, String pw);
	
}
