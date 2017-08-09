package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.domain.Employee;
import com.revature.domain.UserNameAlreadyExist;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	// implemented
	//semi tested
	// creates a new employee to be added to the DATABASE
	// also returns the U_ID and sets the UR_ID to 3 as the default. 
	@Override
	public Employee CreateNewEmp(String us, String pw, String fname, String lname, String email) {
		Employee temp = new Employee();
		CallableStatement cs = null;
		try(Connection conn = ConnectionUtil.getConnectionProp()){
			String sql = "{CALL P_ADD_NEW_USER(?, ?, ?, ?, ?, ?)}";
			cs = conn.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, us);
			cs.setString(3, pw);
			cs.setString(4, fname);
			cs.setString(5, lname);
			cs.setString(6, email);
			cs.execute();
			temp.setU_ID(cs.getInt(1));
			temp.setU_USERNAME(us);
			temp.setU_PASSWORD(pw);
			temp.setU_FIRSTNAME(fname);
			temp.setU_LASTNAME(lname);
			temp.setU_EMAIL(email);
			
			cs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return temp;
	}

	
	// implemented
	// this login returns true or false;
	@Override
	public boolean LoginIn(String us, String pw) {
		Employee temp = new Employee();
		CallableStatement cs = null;
		try(Connection conn = ConnectionUtil.getConnectionProp()){
			String sql = "{CALL P_CHECK_USER_PASSWORD( ?, ?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setString(3, us);
			cs.setString(4, pw);
			cs.execute();
			if(cs.getString(1).equals(us) && cs.getString(2).equals(pw)) {
				System.out.println("UserName and password match");
				return true;
			}else if(!cs.getString(1).equals(us) || !cs.getString(2).equals(pw) ) {
				System.out.println("Either username or password does not match");
				return false;
			}
			
		}catch(SQLException e) {
			System.out.println("Either username or password does not match");
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}


	// implemented
	// this login returns user info for current user
	// that's if their info does match our info
	@Override
	public Employee LoginIn2(String us, String pw) {
		Employee temp = new Employee();
		CallableStatement cs = null;
		try(Connection conn = ConnectionUtil.getConnectionProp()){
			String sql = "{CALL P_GET_USER_INFO_FROM_PASSWORD( ?, ?, ?, ?, ?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, us);
			cs.setString(2, pw);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			temp.setU_ID(cs.getInt(3));
			temp.setU_USERNAME(us);
			temp.setU_PASSWORD(pw);
			temp.setU_FIRSTNAME(cs.getString(4));
			temp.setU_LASTNAME(cs.getString(5));
			temp.setU_EMAIL(cs.getString(6));
			temp.setUR_ID(cs.getInt(7));
		}catch(SQLException e) {
			System.out.println("User info does not match our records.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	
	

}
