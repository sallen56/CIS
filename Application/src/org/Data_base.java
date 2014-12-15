package org;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.rowset.CachedRowSetImpl;
public  class Data_base implements User_Database  {
		JTable table;
		boolean success;
		String value;
		String value2;
		DefaultComboBoxModel listModel;
		DefaultComboBoxModel listModel2;
		DefaultComboBoxModel listModel3;
		JTable customer;
		boolean addItem;
		String valueTicket;
		
	//	HomePage test= new HomePage();
		// Create a variable for the connection string.
				String connectionUrl = "jdbc:sqlserver://REESEY\\TEST:1433;" +
					"databaseName=Final_Project;user=sa;password=Testing123";

				// Declare the JDBC objects.
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				CachedRowSetImpl crs ;
				private JTable flighttable;
				
				// method to login
				public boolean login(String username, String password){
				
		        	try {
		        	// Establish the connection.
		        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            		con = DriverManager.getConnection(connectionUrl);
		            
		            		// Create and execute an SQL statement that returns some data.
		            		String SQL = "select User_N,User_Password from User_LogIN where User_N='"+username+"' and User_Password='"+password+"';";
		            		stmt = con.createStatement();
		            		rs = stmt.executeQuery(SQL);
		            		 
		            		if(rs.next())
		            			return true;
		            			
		            		
		            	
		            		
		        	}
		        
				// Handle any errors that may have occurred.
				catch (Exception e) {
					e.printStackTrace();
					return false;
				}

 				finally {
					if (rs != null) try { rs.close(); } catch(Exception e) {}
			    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			    		if (con != null) try { con.close(); } catch(Exception e) {}
				}
					return false;
					
			}
				public static void main(String[]args){
					Data_base test= new Data_base();
					test.getLogin("Goldy", "yesss", "happy people");
				}
				
				// method to check if a user is an admin
				public boolean isAdmin(String username){
					try {
			        	// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = "Select User_N from Admin where User_N='" + username + "';";
			            		stmt = con.createStatement();
			            		rs = stmt.executeQuery(SQL);
			            	
			            		if(rs.next())
			            			return true;
			            	
			            		
			            		
			            		
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e) {
						e.printStackTrace();
					}

	 				finally {
						if (rs != null) try { rs.close(); } catch(Exception e) {}
				    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				    		if (con != null) try { con.close(); } catch(Exception e) {}
					}
					return false;
				}
				
				public void addUser(String sFirstName, String sLastName, String sAddress,String sCity, String sState,String sZip,String dOB, String sUserName,
						String sPassword, String sEmail, String lSSN,String sSecurity_Question,String answer){
							try {
					        	// Establish the connection.
					        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					            		con = DriverManager.getConnection(connectionUrl);
					            
					            		// Create and execute an SQL statement that returns some data.
					            		String SQL = "insert into User_Info (LastName,FirstName,Address_Mail,City,State_abbr,Zip,SSN,DateOfBirth) values('"
					            		+ sLastName+"',"+"'" +sFirstName+"',"+ "'"+sAddress+"',"+ "'"+sCity+"',"+"'"+sState+"',"+"'"+sZip+"',"+"'"+lSSN+"',"
					            		+"'"+dOB+"');"
					            				+ "insert into User_LogIN (User_N,User_Password,Email,Security_Question,SSN,SecurityAnswer) values('"
					            		+sUserName+"',"+"'"+sPassword + "',"+ "'"+sEmail+"',"+ "'"+ sSecurity_Question+"',"+"'"+lSSN+"',"+"'"+answer +"');";
					            		stmt = con.createStatement();
					            		stmt.execute(SQL);
					            		JOptionPane.showMessageDialog(null, "Created User Please Login");
					            		success=true;
					            		
					            		
					            		
					            		
					        	}
					        
							// Handle any errors that may have occurred.
							catch (Exception e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, "Sorry Something went wrong please check values and try again");
								success=false;
								
							
							}

			 				finally {
			 						
						    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
						    		if (con != null) try { con.close(); } catch(Exception e) {}
							}
							
						}
						
						// method to search flights and return a JTable populated with the information from the search
						
				public  JTable searchFlight(String dept, String arrival){
					
					
					try {
			        	// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = " Select  * from flight where dept_city='" + dept  + "' and Dest_City='" + arrival+ "';";
			            		stmt = con.createStatement();
			            		rs = stmt.executeQuery(SQL);
			            		TableModel model;
			            	
			            		model=buildTableModel(rs);
			            		
			            		
			            	
			            		while(rs.next()){
			            			valueTicket= rs.getString(0);
			            			
			            		}
			            		
								table=new JTable(model);
			            		
			            		
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e) {
						e.printStackTrace();
					}

					finally {
						if (rs != null) try { rs.close(); } catch(Exception e) {}
				    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				    		if (con != null) try { con.close(); } catch(Exception e) {}
					}
					return table;
					
				}
					public  JTable adminFlight(){
						
						
						try {
				        	// Establish the connection.
				        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				            		con = DriverManager.getConnection(connectionUrl);
				            
				            		// Create and execute an SQL statement that returns some data.
				            		String SQL = " Select  * from flight;";
				            		stmt = con.createStatement();
				            		rs = stmt.executeQuery(SQL);
				            		TableModel model;
				            	
				            		model=buildTableModel(rs);
				            		
				            		
				            		
									flighttable=new JTable(model);
				            		
				            		
				        	}
				        
						// Handle any errors that may have occurred.
						catch (Exception e) {
							e.printStackTrace();
						}

						finally {
							if (rs != null) try { rs.close(); } catch(Exception e) {}
					    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
					    		if (con != null) try { con.close(); } catch(Exception e) {}
						}
						return table;
						
					
					
					}
					
				
				public void updateFlight() {
					// TODO Auto-generated method stub
					
				}
				public void addFlight() {
					// TODO Auto-generated method stub
					
				}
				public void deleteFlight() {
					// TODO Auto-generated method stub
					
				}
				
				public void getLogin(String username, String securityQuestion, String answer){
					
					try {
			        	// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = " select User_Password from User_LogIN where User_N='"+username+"' and Security_Question='"+
			            		securityQuestion+"'and SecurityAnswer='"+ answer +"';";
			            		stmt = con.createStatement();
			            		rs = stmt.executeQuery(SQL);
			            		 
			            		if(rs.next())
			            			JOptionPane.showMessageDialog(null, "your password is " +rs.getString(1));
			            		else
			            			JOptionPane.showMessageDialog(null, "Sorry could not find your account please check the information you entered and try again");
			            		
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e) {
						e.printStackTrace();
					}

	 				finally {
						if (rs != null) try { rs.close(); } catch(Exception e) {}
				    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				    		if (con != null) try { con.close(); } catch(Exception e) {}
					}
					
				}
				
				public int bookFlight(String flightNum, int numOfTickets){
					int returnresult = 0;
					try {
			        	// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = " select tickets from flight where Flight_Num='"+flightNum+"';";
			            		stmt = con.createStatement();
			            		rs = stmt.executeQuery(SQL);
			            		
			            		while(rs.next()){
			            			
			            			
			            		returnresult=rs.getInt("tickets")-numOfTickets;
			            		}
			            		
			            			
			            		String input = " update flight set tickets='" +returnresult+ "'where Flight_Num='"+ flightNum+"';";
			            		stmt = con.createStatement();
			            		stmt.execute(input);
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e) {
						e.printStackTrace();
					}

	 				finally {
						if (rs != null) try { rs.close(); } catch(Exception e) {}
				    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				    		if (con != null) try { con.close(); } catch(Exception e) {}
					}
					return returnresult;
					
				}
				public  void getFlights(){
					try {
			        	// Establish the connection.
			        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			            		con = DriverManager.getConnection(connectionUrl);
			            
			            		// Create and execute an SQL statement that returns some data.
			            		String SQL = " select Dept_City,Dest_City,Dept_Dte from flight;";
			            		stmt = con.createStatement();
			            		rs = stmt.executeQuery(SQL);
			            		
			            		listModel = new DefaultComboBoxModel();
			            		listModel2 = new DefaultComboBoxModel();
			            		listModel3= new DefaultComboBoxModel();
			            		
			            		
			            		 
			            		while(rs.next()){
			            			listModel.addElement(rs.getString(1));
			            			listModel2.addElement(rs.getString(2));
			            			listModel3.addElement(rs.getString(3));
			            		}
			            			
			            		
			        	}
			        
					// Handle any errors that may have occurred.
					catch (Exception e) {
						e.printStackTrace();
					}

	 				finally {
						if (rs != null) try { rs.close(); } catch(Exception e) {}
				    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				    		if (con != null) try { con.close(); } catch(Exception e) {}
					}
					
				}
					
					
				
				// mehtod to create a TableModel that will create a JTable from the returned result set
				public static DefaultTableModel buildTableModel(ResultSet rs)
				        throws SQLException {

				    ResultSetMetaData metaData = rs.getMetaData();

				    // names of columns
				    Vector<String> columnNames = new Vector<String>();
				    int columnCount = metaData.getColumnCount();
				    columnNames.addElement("Flight Number");
				    columnNames.addElement("Departing City");
				    columnNames.addElement("Departing State");
				    columnNames.addElement("Destination City");
				    columnNames.addElement("Destination State");
				    columnNames.addElement("Airline");
				    columnNames.addElement("Departing Time");
				    columnNames.addElement("Departing Date");
				    columnNames.addElement("Tickets");

				    // data of the table
				    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
				    while (rs.next()) {
				        Vector<Object> vector = new Vector<Object>();
				        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				            vector.add(rs.getObject(columnIndex));
				        }
				        data.add(vector);
				    }

				    return new DefaultTableModel(data, columnNames);

				}
			
	
}
				