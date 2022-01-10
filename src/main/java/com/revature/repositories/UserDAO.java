package com.revature.repositories;

import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// UserDAO has one method to receive by username, and another method to create a new user by username

public class UserDAO {
	
	//=======Username check Unique method =====================
	// to be called by createUser or updateUser
	public boolean usernameUnique (String username) {
		
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
    		if (rsResult.equalsIgnoreCase(username)== false) {
    			return true;
    		}     			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify username!");
			e.printStackTrace();
		}		
    return false;
    		
    }
// ============ Username Check Existence ==========================	
	
public boolean usernameNull (String username) {
		
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
    		if (rsResult.isEmpty()) {
    			return true;
    		}     			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify username!");
			e.printStackTrace();
		}		
    return false;
    		
    }
	
	
	
	
	// ======== @@@@@@@@@@  to do @@@@@@@@@@@@ ============
	
	
		
	
	
	
	/**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
	
// === Menu M7 required  Done 211231 ========Get User by Username =============================================
	
    public Optional<User> getByUsername(String username) { // username should be unique in DB
    	try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "ers_username,\n"
    				+ "user_first_name, \n"
    				+ "user_last_name, \n"
    				+ "user_email, \n"
    				+ "user_role_id\n"
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
    		User userbyid = new User();
    		
    		// while there are results in the ResultSet..
    		while(rs.next()) {
    			// use the all args constructor to create a new User object from each returned row from the DB
    			User u = new User(
    				// we want to use rs.get from each column in the record
    				//	rs.getInt("ers_user_id"),		// DB use only?
    					rs.getString("ers_username"),  // 211231 says Null. why?
    					rs.getString("user_first_name"),
    					rs.getString("user_last_name"),
    				//	rs.getString("ers_password"), // confidential?
    					rs.getString("user_email"),
    					rs.getInt("user_role_id")
    					);
    			// populate the ArrayList with each new User object
    			//userList.add(u); // u is the new User object we created above
    			userbyid = u;
    			
    			//Optional<User> userbyid = Optional.ofNullable(u);
    		}
    		
    		// when there are no more results in rs, the while loop will break
    		// then return the populated ArrayList of Users
    		//return userbyid; // error msg: cannot be resolved to a variable
    		//return Optional.of(userbyid);
    		return Optional.ofNullable(userbyid);
    				
    	} catch (SQLException e) {
    		System.out.println("Somethiong went wrong selecting users by username!");
    		e.printStackTrace();
    	}
    	
        return Optional.empty();
        
    }
    
// ===== Menu =M9 done 211231================Get All Users====================================================    
 	//public Optional<User> getAllDBUsers() {
    public Optional<List<User>> getAllUsers() {
    	
    	try(Connection conn = ConnectionFactory.getConnection()) {
        		// Initiate an empty ResultSet object that will store the results of our SQL query
        		ResultSet rs = null;
        		// Write a query that we want to send to the database, and assign it to a String
        		//String sql = "SELECT * FROM rev1p211206.ers_users;";
        		//String sql = "SELECT * FROM ers_users";
        		String sql = " SELECT \n"
        				+ "ers_username,\n"
        				+ "user_first_name, \n"
        				+ "user_last_name, \n"
        				+ "user_email, \n"
        				+ "user_role_id\n"
        				+ "FROM ers_users\n";
        				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n";
        			      		
        		// schema name to inlcude, so JDBC can see the table
        		// Put the SQL query into a Statement object (The Connection object has a method for this)
        		Statement statement = conn.createStatement(); // no sql as parameter
        	      		
        		// Execute the query, by putting the results into our ResultSet object
        		// The Statement object has a method that takes Strings to execute as a SQL query
        		rs = statement.executeQuery(sql);
        		
        		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
        		
        		//Create an empty ArrayList to be filled with the data from the database
        		//Optional<List<User>> oul = Optional.empty();
        		        		
        		List<User> userList = new ArrayList<>();
        		//Optional<List<User>> oul = Optional.ofNullable(userList);
        		//oul = Optional.ofNullable(userList);
        		
        		
        	// if(oul.isPresent()) {
        		// while there are results in the ResultSet..
        		while(rs.next()) {
        			// use the all args constructor to create a new User object from each returned row from the DB
        			User u = new User(
        				// we want to use rs.get fro each column in the record
        				//	rs.getInt("ers_user_id"),		// DB use only
        					rs.getString("ers_username"),  // confidential
        					rs.getString("user_first_name"),
        					rs.getString("user_last_name"),
        				//	rs.getString("ers_password"), // confidential
        					rs.getString("user_email"),
        					rs.getInt("user_role_id")
        					);
        			// populate the ArrayList with each new User object
        			userList.add(u); // u is the new User object we created above
        			//System.out.println(u.getUsername());
        			////System.out.println(u.toString());
        		}
        	 // if Optional.isPresent() is true
        		// when there are no more results in rs, the while loop will break
        		// then return the populated ArrayList of Users
        		//// return Optional.ofNullable(u);
        		System.out.println("UserDAO alluser return having no records is " + userList.isEmpty());
        		return Optional.ofNullable(userList);
        		//return Optional.ofNullable(oul.get());
    		//}	
        } catch (SQLException e) {
        		System.out.println("Somethiong went wrong selecting all users!");
        		e.printStackTrace();
        }
        	
            return Optional.empty();
            
     }
    	
   	
// ====  Menu E1 Done 211231 ==========Create New User ==========================  

    
    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
    
    
    public void create(User userToBeRegistered) {
    	
    	RegistrationUnsuccessfulException noRegis = new RegistrationUnsuccessfulException();
    	
    	try(Connection conn  = ConnectionFactory.getConnection()) {
    		// check whether username is unique
        	
        	// check whether email address is unique
        	
        	
        	
        	
        	
        		
    		
    		
    		
    		String sql = "INSERT INTO ers_users \n"
    				+ "(ers_username, \n"    //1 unique, not null
    				+ "ers_password, \n"      //2   not null
    				+ "user_first_name, \n"   // 3 
    				+ "user_last_name, \n"    // 4
    				+ "user_email, \n"        // 5 unique, not null, 
    				+ "user_role_id) \n"      // 6
    				+ "VALUES (?,?,?,?,?,?)";
    		// insert by fields only, not by SQL stmt
    		PreparedStatement ps = conn.prepareStatement(sql);
   		// parameter for reach question mark per order above 
    		ps.setString(1, userToBeRegistered.getErs_username());  // required entry: username
    		ps.setString(2, userToBeRegistered.getErs_password());  // required entry: password
    		ps.setString(3, userToBeRegistered.getUser_first_name());
    		ps.setString(4, userToBeRegistered.getUser_last_name());
    		ps.setString(5, userToBeRegistered.getUser_email());   // required entry: email
    		ps.setInt(6, userToBeRegistered.getUser_role_id());     // required entry: role id
    		
    		// executeUpdate, not execute query    		
    		ps.executeUpdate();  // 
   		
  		
    		System.out.println("User Registration Successful! --userDAO");		// shown after closed and opened after the above correction 211229
    		
    		
    		} catch(SQLException e) {
    			System.out.println("User registration has failed. --userDAO");
    			e.printStackTrace();
    			
    		}
 	
    		if (Optional.ofNullable(userToBeRegistered) == null) {
    			// 220101
    			
    			// noRegis("User registration not completed. Please try again.");
    		}
    		
    		
    		noRegis.printStackTrace();
    	
    	
        // return Optional.ofNullable(userToBeRegistered);
    }
    
// ==== Menu E2 Employee User Update ====Done 12:32am 220104 =====================================================
    
//    public User eupdate(User unupdated) {
//    	try(Connection conn  = ConnectionFactory.getConnection()) {
// //   	ResultSet rs = null;	// error: Duplicate local variable
//    	String SQL1 = "UPDATE ers_users SET user_email = ? WHERE ers_users_id = ?";
//    	PreparedStatement ps1 = conn.prepareStatement(SQL1);
//    	ps1.setString(1,  unupdated.getUser_enmail());
//    	ps1.setInt(2,  unupdated.getErs_users_id());  // 
//    	
//    	int userId = unupdated.getErs_users_id();
//    
//    	int affectedRows = ps1.executeUpdate();		
//    	//ps1.close();
//    	
//    	//ResultSet rs = ps1.getResultSet(); // NoPointerException
//    	
//    	// now receive from DB the updated user
//    	String SQL2 = "SELECT * FROM ers_users WHERE ers_users_id = ?";  // typo ers_user_id
//    	PreparedStatement ps2 = conn.prepareStatement(SQL2);
//    	//ps2.setInt(1, 1);
//    	ps2.setInt(1, userId);
//    	ResultSet rs = ps2.executeQuery();
//    	
//    
//    	//System.out.println(rs.toString());
//    	while (rs.next()) {
//    		User updatedU = new User(		// per user email-only constructor
//    		rs.getInt("ers_users_id"),		// DB use only
////			rs.getString("ers_username"),  // confidential
////			rs.getString("user_password"),
//			rs.getString("user_first_name"),
//			rs.getString("user_last_name"),
//			rs.getString("user_email")
////			rs.getInt("user_role_id")
//			);
//    	//return unupdated;
//    	return updatedU;
//    	}
//    	} catch(SQLException e) {
//			System.out.println("Employee user update has failed.");
//			e.printStackTrace();
//			
//		}
//    	
//    	return null;
//    }
    
    
    
// public void insertNewUser(User newUser) {
//		
//		try(Connection conn  = ConnectionFactory.getConnection()) {
//		String sql = "INSERT INTO ers_users (ers_username, e_lname, e_role, e_age) values (?,?,?,?)";
//		// insert by fields only, not by SQL stmt
//		PreparedStatement ps = conn.prepareStatement(sql);
//		
//		ps.setString(1, challengeEmployee.getE_fname());
//		ps.setString(2, challengeEmployee.getE_lname());
//		ps.setString(3, challengeEmployee.getE_role());
//		ps.setInt(4, challengeEmployee.getE_age());
//		
//		
//		
//		//ps.executeUpdate(sql); // 
//		ps.executeUpdate();  // result did not show immediately after the code change 211229
//		
//		
//		System.out.println("Added to Database --DAOimpl");		// shown after closed and opened after the above correction 211229
//		
//		} catch(SQLException e) {
//			System.out.println("Creating the employee has failed.");
//			e.printStackTrace();
//		}
//	}
    
    
    
    
    
    
    
}

