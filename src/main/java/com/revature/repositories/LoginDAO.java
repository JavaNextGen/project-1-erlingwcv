package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.MyPasswordNoMatchException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class LoginDAO {
	
	
	
	
	//hardcoding username/password - which you WON'T do in P1
	
	//=======Login Username Match method =====================
	// to be called by createUser or updateUser
	public boolean usernameMatch (String username) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "ers_username,\n"
    				+ "FROM ers_users\n"
    				//+ "LEFT JOIN ers_user_roles \n"
    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
    				+ "WHERE ers_username = ?";

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		PreparedStatement ps = conn.prepareStatement(sql);
    		// put the username parameter in the PreparedStatement to complete the SQL
    		ps.setString(1, username); // 1st question mark in SQL, its variable
    		
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		rs = ps.executeQuery(); // sql already included in ps on line 33
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    		String  rsResult = rs.getString("ers_username");
    		if (rsResult.equalsIgnoreCase(username)== true) {
    			return true;
    		}     			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify username!");
			e.printStackTrace();
		}		
    return false;
    		
    }
	
// ======== Login User Email Match Method ==========================================	
	// to be called by createUser or updateUser
	public boolean passwordMatch (String password) {
	
		try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "ers_password,\n"
    				+ "FROM ers_users\n"
    				//+ "LEFT JOIN ers_user_roles \n"
    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
    				+ "WHERE ers_password = ?";

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		PreparedStatement ps = conn.prepareStatement(sql);
    		// put the email parameter in the PreparedStatement to complete the SQL
    		ps.setString(1, password); // 1st question mark in SQL, its variable
    		
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		rs = ps.executeQuery(); // sql already included in ps on line 33
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    		String  rsResult = rs.getString("ers_password");
    		if (rsResult.equalsIgnoreCase(password)== true) {
    			return true;
    		}  else {
    			throw new MyPasswordNoMatchException("Password No Match");
    		
    		
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify password!");
			e.printStackTrace();
		} catch (MyPasswordNoMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Password Incorrect. Try Again");
		} 	
    return false;

	};


	
						
				
		
// =========== Login 1 to grant a user access to corresponding ERS menus   ==================================================
				
	public User login(String username, String password) { // username should be unique in DB
		try(Connection conn = ConnectionFactory.getConnection()) {
					
					
					//Typically, you'll want to validate username/password against some username/password in the DATABASE.
					//So in your P1, you'd be sending the data sent into the LoginDTO... 
					//and most likely doing some DAO method that uses those values to check for matching values in the DB.
					//soooooo we probably need a DAO method that has something like: 
						//"select * from users where username = ? and password = ?" and then insert the values of the DTO for parameters
					
					//public boolean login(String username, String password) {
					//	
					//	//this is hardcoding - telling Java exactly what values make for a valid login
					//	//in reality, you'll check the database for a username/password to see if a record exists
					//	if(username.equals("user") && password.equals("password")) {
							
					//		return true; //true indicates successful login
							
			// should return Role so corresponding menu can be presented to user
	
		boolean unameMatch = this.usernameMatch(username);
		boolean pwMatch = this.passwordMatch(password);
					
			if (unameMatch == true && pwMatch == true) {
					
			// Initiate an empty ResultSet object that will store the results of our SQL query		
					ResultSet rs = null;
					
					// Write a query that we want to send to the database, and assign it to a String
					// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
					// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
			 		//String sql = "SELECT * FROM ers_users WHERE ers_username = ? ers_password =? ";
					String sql = " SELECT \n"
		    				+ "ers_user_id, \n"
							+ "user_role_id\n"
		    				+ "FROM ers_users\n"
		    				//+ "LEFT JOIN ers_user_roles \n"
		    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
		    				+ "WHERE ers_username = ? ers_password =? ";
			 		
			
					// schema name to be included. otherwise JDBC do not see the table
					// Put the SQL query into a Statement object (The Connection object has a method for this)
					// Statement statement = conn.createStatement();
					// This time should use PreparedStatement to prevent SQL injection
					PreparedStatement ps = conn.prepareStatement(sql);
					// put the username parameter in the PreparedStatement to complete the SQL
					ps.setString(1, username); // 1st question mark in SQL, its variable
					ps.setString(2, password); // 1st question mark in SQL, its variable
					
					// Execute the query, by putting the results into our ResultSet object
					// The Statement object has a method that takes Strings to execute as a SQL query
					//rs = statement.executeQuery(sql);
					rs = ps.executeQuery(); // sql already included in ps on line 33
					
					// All the above makes a call to our database. Now we need to store the data in an ArrayList.
					
					//if (rs.wasNull()== false) {
						// while there are results in the ResultSet..
					//try {	
							while(rs.next()) {
							// use the all args constructor to create a new User object from each returned row from the DB
							User loginUser = new User(
								// we want to use rs.get from each column in the record
									rs.getInt("ers_user_id"),		// DB use only?
								//	rs.getString("ers_username"),  // 211231 says Null. why?
								//	rs.getString("ers_password"), // confidential?
								//	rs.getString("user_first_name"),
								//	rs.getString("user_last_name"),
								//	rs.getString("user_email"),
									rs.getInt("user_role_id")
									);
							// populate the ArrayList with each new User object
							return loginUser;
								 
							}
			}
							//} catch (SQLException e) {	
												
					//	System.out.println("Username and/or Password did not match");
					//	e.printStackTrace();
					//}
					
					// when there are no more results in rs, the while loop will break
					// then return the populated ArrayList of Users
					//return userbyid; // error msg: cannot be resolved to a variable
					//return Optional.of(userbyid);
					//return Optional.ofNullable(userbyid);
							
			} catch (SQLException e) {
					System.out.println("Somethiong went wrong during logging by username!");
					e.printStackTrace();
			}
				
	return null;
		 

	}	
	
		
		
	

}

