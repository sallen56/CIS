package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public interface User_Database {
	
	
		
		
		
	public boolean login(String username, String password);
	
	public boolean isAdmin(String username);
	
	public void addUser(String sFirstName, String sLastName, String sAddress,String sCity, String sState,String sZip,String dOB, String sUserName,
			String sPassword, String sEmail, String lSSN,String sSecurity_Question,String answer);
			
				
	public  JTable searchFlight(String dept, String arrival);
	
	abstract public void updateFlight();
	
	abstract public void addFlight();
	
	abstract public void deleteFlight();


}


