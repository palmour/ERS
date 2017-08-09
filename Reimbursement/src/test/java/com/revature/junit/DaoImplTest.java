package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.UserNameAlreadyExist;

public class DaoImplTest {

	@Ignore
	@Test
	public void creationShouldCreateAndReturnValue() {
		Employee emp = new Employee();
		System.out.println("Testing the creation of a new user and that info is stored");
		ReimbursementDaoImpl tester = new ReimbursementDaoImpl();
		emp = tester.CreateNewEmp("Ahern", "pass", "Alma", "Hernandez", "al@gmail.com");
		assertNotNull(emp.getU_ID());
	}
	
	@Ignore
	@Test
	public void CheckLogin() {
		boolean result;
		String us = "erosales";
		String pw = "pass";
		System.out.println("Testing to check if user can login.");
		ReimbursementDaoImpl tester = new ReimbursementDaoImpl();
		result = tester.LoginIn(us, pw);
		assertTrue(result);
		
	}
	@Ignore
	@Test
	public void FailCheckLoginExample() {
		boolean result;
		String us = "erosales";
		String pw = "wrongpass";
		System.out.println("Testing to check if user can login.");
		ReimbursementDaoImpl tester = new ReimbursementDaoImpl();
		result = tester.LoginIn(us, pw);
		assertTrue(result);
		
	}
	
	@Test
	public void CheckLogin2() {
		Employee temp = new Employee();
		String us = "erosales";
		String pw = "pass";
		System.out.println("Testing to check if user can login.");
		ReimbursementDaoImpl tester = new ReimbursementDaoImpl();
		temp = tester.LoginIn2(us, pw);
		System.out.println(temp);
		assertNotNull(temp);
	}
	
}
