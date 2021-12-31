package com.revature.repositories;

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
    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) { // username should be unique in DB
    	try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
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
    
    
 	public Optional<User> getAllDBUsers() {
    //public Optional<List<User>> getAllUsers() {
    	
    	     try(Connection conn = ConnectionFactory.getConnection()) {
        		// Initiate an empty ResultSet object that will store the results of our SQL query
        		ResultSet rs = null;
        		// Write a query that we want to send to the database, and assign it to a String
        		String sql = "SELECT * FROM rev1p211206.ers_users;";
        		// schema name to inlcude, so JDBC can see the table
        		// Put the SQL query into a Statement object (The Connection object has a method for this)
        		Statement statement = conn.createStatement();
        		// Execute the query, by putting the results into our ResultSet object
        		// The Statement object has a method that takes Strings to execute as a SQL query
        		rs = statement.executeQuery(sql);
        		
        		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
        		
        		//Create an empty ArrayList to be filled with the data from the database
        		//Optional<List<User>> oul = Optional.empty();
        		System.out.println("rs class is "+rs.getClass());
        		System.out.println("rs class fetch size is "+rs.getFetchSize());
        		
        		List<User> userList = new ArrayList<>();
        		//Optional<List<User>> oul = Optional.ofNullable(userList);
        		//oul = Optional.ofNullable(userList);
        		
        		
        //	if(oul.isPresent()) {
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
        			System.out.println(u.getUsername());
        			////System.out.println(u.toString());
        		}
       // 	} // if Optional.isPresent() is true
        		// when there are no more results in rs, the while loop will break
        		// then return the populated ArrayList of Users
        		//// return Optional.ofNullable(u);
        		//return Optional.ofNullable(userList);
        		//return Optional.ofNullable(oul.get());
        		
        	} catch (SQLException e) {
        		System.out.println("Somethiong went wrong selecting all users!");
        		e.printStackTrace();
        	}
        	
            return Optional.empty();
            
     }
    	
    	
    

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
    public User create(User userToBeRegistered) {
    	
    	
    	
    	
    	
        return userToBeRegistered;
    }
}
