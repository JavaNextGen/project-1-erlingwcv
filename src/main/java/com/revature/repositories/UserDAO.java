package com.revature.repositories;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
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
    public Optional<List<User>> getByUsername(String username) { // it is now NOT Optional<User>
    	try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		// Write a query that we want to send to the database, and assign it to a String
    		String sql = "SELECT * FROM ers_users WHERE ers_username = username;";
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		Statement statement = conn.createStatement();
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		rs = statement.executeQuery(sql);
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		List<User> userList = new ArrayList<>();
    		
    		// while there are results in the ResultSet..
    		while(rs.next()) {
    			// use the all args constructor to create a new User object from each returned row from the DB
    			User u = new User(
    				// we want to use rs.get fro each column in the record
    				//	rs.getInt("ers_user_id"),		// DB use only
    				//	rs.getString("ers_username"),  // confidential
    					rs.getString("user_first_name"),
    					rs.getString("user_last_name"),
    				//	rs.getString("ers_password"), // confidential
    					rs.getString("user_email"),
    					rs.getInt("user_role_id")
    					);
    			// populate the ArrayList with each new User object
    			userList.add(u); // u is the new User object we created above
    		}
    		
    		// when there are no more results in rs, the while loop will break
    		// then return the populated ArrayList of Users
    		return Optional.ofNullable(userList);
    				
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
        		String sql = "SELECT * FROM ers_users;";
        		// Put the SQL query into a Statement object (The Connection object has a method for this)
        		Statement statement = conn.createStatement();
        		// Execute the query, by putting the results into our ResultSet object
        		// The Statement object has a method that takes Strings to execute as a SQL query
        		rs = statement.executeQuery(sql);
        		
        		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
        		
        		//Create an empty ArrayList to be filled with the data from the database
        		//Optional<List<User>> oul = Optional.empty();
        		List<User> userList = new ArrayList<>();
        		//oul = Optional.ofNullable(userList);
        		
        		
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
        			System.out.println(u);
        		}
        		
        		// when there are no more results in rs, the while loop will break
        		// then return the populated ArrayList of Users
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
